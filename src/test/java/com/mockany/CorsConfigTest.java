package com.mockany;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CorsConfigTest {

    public static final String ALL = "*";
    public static final String PATH_ALL = "/**";
    @Mock
    private CorsRegistry registry;

    @Mock
    private CorsRegistration registration;

    @InjectMocks
    private CorsConfig config;

    @Before
    public void setUp() {
        initMocks( this );
    }

    @Test
    public void addCorsMappings() throws Exception {
        when( registry.addMapping( PATH_ALL ) ).thenReturn( registration );
        when( registration.allowedOrigins( "*" ) ).thenReturn( registration );
        config.addCorsMappings( registry );
        verify( registry ).addMapping( PATH_ALL );
        verify( registration ).allowedOrigins( ALL );
        verify( registration ).allowedMethods( "GET", "POST", "OPTIONS" );
        verifyNoMoreInteractions( registration );
        verifyNoMoreInteractions( registry );
    }

}
