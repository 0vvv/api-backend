package com.lin.apibackend.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserInterfaceInfoServiceTest {
    @Resource UserInterfaceInfoService userInterfaceInfoService;

    @Test
    public void testInvokeCount() {
        long interfaceInfoId = 1;
        long userId = 1;
        boolean result = userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
        System.out.println(result);
    }
}
