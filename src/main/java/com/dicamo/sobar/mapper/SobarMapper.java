package com.dicamo.sobar.mapper;

import com.dicamo.sobar.dto.LabelDto;
import com.dicamo.sobar.dto.ProductDto;
import com.dicamo.sobar.dto.SobarDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 해당 클래스가 mapper로 작동한다는 것을 spring framework에 알림
// 인터페이스로 구현하고 resources/mapper/sobar/sql-sobar.xml에서 sql문을 작성하여 구현
@Mapper
public interface SobarMapper {

    SobarDto selectUuid(String uuid);

    List<ProductDto> selectBarcode(String productId);

    void insertSobar(String uuid);

    void insertLabel(LabelDto label);
}
