package com.example.jehad.jobfinder.data.rest.base;

import com.example.jehad.jobfinder.constants.ProviderNames;
import com.example.jehad.jobfinder.data.model.provider.BaseProvider;
import com.example.jehad.jobfinder.data.model.provider.GithubProvider;
import com.example.jehad.jobfinder.data.model.provider.SearchGovProvider;
import com.example.jehad.jobfinder.data.rest.api.ApiProviderInterface;
import com.example.jehad.jobfinder.data.rest.base.BaseProviderStrategiesUtils;
import com.example.jehad.jobfinder.ui.main.viewholder.GitHubViewHolder;
import com.example.jehad.jobfinder.ui.main.viewholder.SearchGovViewHolder;

/**
 * The responsible class on the provider list strategies
 */
public class ProviderStrategies extends BaseProviderStrategiesUtils {

    /**
     * The full provider types, a new provider type should be added here .
     */
    public enum ProviderType {
        GITHUB {
            @Override
            public BaseProvider create() {
                return new GithubProvider(ProviderNames.GITHUB, this, GitHubViewHolder.class, ApiProviderInterface.Github.class);
            }
        },
        SEARCH_GOV {
            @Override
            public BaseProvider create() {
                return new SearchGovProvider(ProviderNames.SEARCH_GOV, this, SearchGovViewHolder.class, ApiProviderInterface.SearchGov.class);
            }
        };

        public abstract BaseProvider create();
    }

}
