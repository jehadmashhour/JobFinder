package com.example.jehad.jobfinder.data.model.job;

import com.example.jehad.jobfinder.data.rest.base.ProviderStrategies;

import java.io.Serializable;

/**
 * The Base Class for every Job Model, So every job model should be extend from it
 */
public abstract class BaseJob implements Serializable {
    public abstract ProviderStrategies.ProviderType getProviderType();
}
