package com.example.jehad.jobfinder.test;

import com.example.jehad.jobfinder.test.model.provider.GithubProvider;
import com.example.jehad.jobfinder.test.model.provider.SearchGovProvider;
import com.example.jehad.jobfinder.test.rest.ProviderStrategies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ProviderStrategiesTest {

    @Test
    public void testGetSearchGovProvider() {
        ProviderStrategies.ProviderType providerType = ProviderStrategies.ProviderType.SEARCH_GOV;
        assertEquals(true, ProviderStrategies.getProvider(providerType) instanceof SearchGovProvider);
    }

    @Test
    public void testGetGithubProvider() {
        ProviderStrategies.ProviderType providerType = ProviderStrategies.ProviderType.GITHUB;
        assertEquals(true, ProviderStrategies.getProvider(providerType) instanceof GithubProvider);
    }

}
