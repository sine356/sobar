package com.dicamo.sobar.dao;

import com.dicamo.sobar.dto.LabelDto;
import com.dicamo.sobar.dto.ProductDto;
import com.dicamo.sobar.dto.SobarDto;

import java.util.List;

// sql의 CRUD를 처리할 dao
// 인터페이스로 정의되어있으며 Impl로 기능구현
public interface SobarDao {
    SobarDto selectUuid(String uuid) throws Exception;
    List<ProductDto> selectBarcode(String productCode) throws Exception;

    void insertSobar(String uuid) throws Exception;
    void insertLabel(LabelDto label) throws Exception;


}
