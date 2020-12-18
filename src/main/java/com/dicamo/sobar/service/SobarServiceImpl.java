package com.dicamo.sobar.service;

import com.dicamo.sobar.dao.SobarDao;
import com.dicamo.sobar.dto.LabelDto;
import com.dicamo.sobar.dto.ProductDto;
import com.dicamo.sobar.dto.SobarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 서비스 구현 클래스
// dao에 의존성을 주입하여 dao를 통해 database를 연결하여 필요한 정보를 가져옴
@Service
public class SobarServiceImpl implements SobarService{

    @Autowired
    SobarDao dao;

    @Override
    public String sobarInsertByUuid(String uuid, List<String> productCode) {
        try{
            for(int i=0; i<productCode.size(); i++){
                List<ProductDto> product = dao.selectBarcode(productCode.get(i));
                SobarDto sobar = dao.selectUuid(uuid);
                int sobar_idx;

                if(sobar != null){
                    sobar_idx = sobar.getIdx_sobar();
                    System.out.println("UUID: " + uuid + " 조회 완료 / idx = " + sobar_idx);
                } else if(sobar == null){
                    dao.insertSobar(uuid);
                    sobar = dao.selectUuid(uuid);
                    sobar_idx = sobar.getIdx_sobar();
                    System.out.println("UUID: " + uuid + " 신규 등록 / idx = " + sobar_idx);
                } else {
                    return "알수없는 에러 (UUID INSERT 실패)";
                }

                if(product.size() >= 1){
                    ProductDto dto = product.get(product.size()-1);
                    System.out.println(productCode.get(i) + ">> 해당 상품의 바코드 조회 : " + dto.getProduct_name());

                    dao.insertLabel(LabelDto.builder()
                            .product_idx(dto.getIdx_product())
                            .sobar_idx(sobar_idx).build());
                    System.out.println(uuid + "에 " + "가격표 추가 완료");

//                    dao.insertLabel();
                } else if(product.size() == 0){
                    System.out.println(productCode.get(i) + ">> 해당 상품의 바코드를 찾을 수 없습니다.");
                    return productCode.get(i) + ">> 해당 상품의 바코드를 찾을 수 없습니다.";
                } else {
                    System.out.println("ERROR : 비정상적인 Product Code Size");
                    return "ERROR : 비정상적인 Product Code Size";
                }
            }
            return "완료";
        }catch (Exception e) {
            e.printStackTrace();
            return "알수없는 에러";
        }
    }
}
