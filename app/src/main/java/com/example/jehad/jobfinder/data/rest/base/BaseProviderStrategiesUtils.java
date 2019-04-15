package com.example.jehad.jobfinder.data.rest.base;

import com.example.jehad.jobfinder.data.model.provider.BaseProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseProviderStrategiesUtils {

    /**
     * @return Get The full Providers list , a new provider should be added here .
     */
    public static List<BaseProvider> getProviderList() {
        List<ProviderStrategies.ProviderType> providerTypes = Arrays.asList(ProviderStrategies.ProviderType.values());
        List<BaseProvider> baseProviders = new ArrayList<>();
        for (ProviderStrategies.ProviderType providerType : providerTypes) {
            baseProviders.add(providerType.create());
        }
        return baseProviders;
    }

    /**
     * @param providerType the current selected {@link ProviderStrategies.ProviderType}
     * @return The {@link BaseProvider} of the specifc {@link ProviderStrategies.ProviderType}
     */
    public static BaseProvider getProvider(ProviderStrategies.ProviderType providerType) {
        return getProviderList().get(providerType.ordinal());
    }
}
