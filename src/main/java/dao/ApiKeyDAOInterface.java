package dao;

import models.ApiKey;

import java.util.List;

public interface ApiKeyDAOInterface {
    public List<ApiKey> getApiKeys();
    public ApiKey checkValidApiKey(String apikey);
}
