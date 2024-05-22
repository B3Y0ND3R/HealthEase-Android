package com.example.healthease.Order;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.healthease.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@RunWith(MockitoJUnitRunner.class)
public class OrderAdapterTest {

    @Mock
    Context context;
    @Mock
    LayoutInflater layoutInflater;
    @Mock
    View convertView;
    @Mock
    ViewGroup parent;
    @Mock
    TextView lineA;
    @Mock
    TextView lineB;
    @Mock
    TextView lineC;
    @Mock
    TextView lineD;
    @Mock
    TextView lineE;

    private OrderAdapter orderAdapter;
    private ArrayList<String> testData;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        testData = new ArrayList<>();
        testData.add("Order1$Product1$100$2$Date1$Time1$300$medicine");
        testData.add("Order2$Product2$200$3$Date2$Time2$400$equipment");

        orderAdapter = new OrderAdapter(context, testData);
    }

    @Test
    public void testGetCount() {
        assertEquals(testData.size(), orderAdapter.getCount());
    }

    @Test
    public void testGetItem() {
        assertEquals(testData.get(0), orderAdapter.getItem(0));
    }

    @Test
    public void testGetItemId() {
        assertEquals(0, orderAdapter.getItemId(0));
    }


}
