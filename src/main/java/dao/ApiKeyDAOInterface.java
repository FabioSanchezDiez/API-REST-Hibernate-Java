package dao;

import models.ApiKey;

import java.util.List;

public interface ApiKeyDAOInterface {
    public List<ApiKey> returnAllApiKeys();
    public ApiKey checkValidApiKey(String apikey, String requestMethod);
    public ApiKey createApiKey(ApiKey apikey);
}
