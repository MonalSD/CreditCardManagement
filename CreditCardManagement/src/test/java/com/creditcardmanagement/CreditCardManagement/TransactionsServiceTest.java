package com.creditcardmanagement.CreditCardManagement;

import com.creditcardmanagement.CreditCardManagement.dto.MerchantAmount;
import com.creditcardmanagement.CreditCardManagement.repo.TransactionMongoTemplate;
import com.creditcardmanagement.CreditCardManagement.repo.TransactionsRepository;
import com.creditcardmanagement.CreditCardManagement.service.TransactionsService;
import com.creditcardmanagement.CreditCardManagement.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;


@SpringBootTest
public class TransactionsServiceTest {
    @Mock
    private TransactionsRepository transactionsRepository;

    @Mock
    private TransactionMongoTemplate dao;

    @InjectMocks
    private TransactionsService transactionsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMerchantAmount() {
        List<MerchantAmount> expected = Collections.singletonList(new MerchantAmount());
        when(dao.getAmountForMerchant()).thenReturn(expected);

        List<MerchantAmount> result = transactionsService.getMerchantAmount();

        assertEquals(expected, result);
        verify(dao, times(1)).getAmountForMerchant();
    }

    @Test
    void testGetSpendingHistoryByCategory() {
        List<CategoryAmount> expected = Collections.singletonList(new CategoryAmount());
        when(dao.getSpendingHistoryByCategory()).thenReturn(expected);

        List<CategoryAmount> result = transactionsService.getSpendingHistoryByCategory();

        assertEquals(expected, result);
        verify(dao, times(1)).getSpendingHistoryByCategory();
    }

    @Test
    void testGetSpendingHistoryByJob() {
        List<JobAmount> expected = Collections.singletonList(new JobAmount());
        when(dao.getSpendingHistoryByJob()).thenReturn(expected);

        List<JobAmount> result = transactionsService.getSpendingHistoryByJob();

        assertEquals(expected, result);
        verify(dao, times(1)).getSpendingHistoryByJob();
    }

    @Test
    void testGetSpendingHistoryByGender() {
        List<GenderAmount> expected = Collections.singletonList(new GenderAmount());
        when(dao.getSpendingHistoryByGender()).thenReturn(expected);

        List<GenderAmount> result = transactionsService.getSpendingHistoryByGender();

        assertEquals(expected, result);
        verify(dao, times(1)).getSpendingHistoryByGender();
    }

    @Test
    void testGetSpendingHistoryByCity() {
        List<CityAmount> expected = Collections.singletonList(new CityAmount());
        when(dao.getSpendingHistoryByCity()).thenReturn(expected);

        List<CityAmount> result = transactionsService.getSpendingHistoryByCity();

        assertEquals(expected, result);
        verify(dao, times(1)).getSpendingHistoryByCity();
    }

    @Test
    void testGetSpendingHistoryByState() {
        List<StateAmount> expected = Collections.singletonList(new StateAmount());
        when(dao.getSpendingHistoryByState()).thenReturn(expected);

        List<StateAmount> result = transactionsService.getSpendingHistoryByState();

        assertEquals(expected, result);
        verify(dao, times(1)).getSpendingHistoryByState();
    }



    @Test
    void testGetTopMerchants() {
        List<TopMerchant> expected = Collections.singletonList(new TopMerchant());
        int limit = 10;
        when(dao.getTopMerchants(limit)).thenReturn(expected);

        List<TopMerchant> result = transactionsService.getTopMerchants(limit);

        assertEquals(expected, result);
        verify(dao, times(1)).getTopMerchants(limit);
    }


}
