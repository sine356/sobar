package com.dicamo.sobar.service;

import java.util.List;

// dao를 이용하여 비즈니스 로직을 처리할 서비스 정의
// 서비스는 인터페이스로 정의되어있으며 Impl에서 기능 구현
public interface SobarService {
    String sobarInsertByUuid(String uuid, List<String> productCode) throws Exception;

}
