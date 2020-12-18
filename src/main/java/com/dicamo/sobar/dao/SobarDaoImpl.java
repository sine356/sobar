package com.dicamo.sobar.dao;

import com.dicamo.sobar.dto.LabelDto;
import com.dicamo.sobar.dto.ProductDto;
import com.dicamo.sobar.dto.SobarDto;
import com.dicamo.sobar.mapper.SobarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// 해당 dao가 Repository로 사용됨을 알림
// bean으로 등록
@Repository
public class SobarDaoImpl implements SobarDao{

    // Mapper에 의존성 주입
    @Autowired
    SobarMapper mapper;

    // t_sobar에 uuid 테이블로 검색해서 SobarDto로 반환
    @Override
    public SobarDto selectUuid(String uuid) throws Exception {
        return mapper.selectUuid(uuid);
    }

    // t_product_aeon 테이블에 barcode 검색하여 list로 반환
    @Override
    public List<ProductDto> selectBarcode(String productCode) throws Exception {
        return mapper.selectBarcode(productCode);
    }

    // t_label 테이블에 LabelDto 객체를 insert
    // LabelDto > sobar_idx, product_idx
    @Override
    public void insertLabel(LabelDto label) throws Exception {
        mapper.insertLabel(label);
    }

    // t_sobar 테이블에 uuid가 검색되지 않았을때 새로운 uuid insert
    @Override
    public void insertSobar(String uuid) throws Exception {
        mapper.insertSobar(uuid);
    }
}
