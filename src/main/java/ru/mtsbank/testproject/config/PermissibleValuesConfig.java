package ru.mtsbank.testproject.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "permissible-values")
public class PermissibleValuesConfig {
    private List<Integer> currency;
    private List<String> documentTypes;

    public List<Integer> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Integer> currency) {
        this.currency = currency;
    }

    public List<String> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(List<String> documentTypes) {
        this.documentTypes = documentTypes;
    }
}
