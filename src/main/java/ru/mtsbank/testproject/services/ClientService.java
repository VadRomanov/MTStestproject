package ru.mtsbank.testproject.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtsbank.testproject.config.PermissibleValuesConfig;
import ru.mtsbank.testproject.data.Account;
import ru.mtsbank.testproject.data.Client;
import ru.mtsbank.testproject.repositories.ClientRep;

import java.sql.Date;
import java.util.List;

@Service
public class ClientService {
    final static Logger logger = LoggerFactory.getLogger("ru.mtsbank.testproject.services.ClientService");

    @Autowired
    private PermissibleValuesConfig permissibleValuesConfig;
    @Autowired
    private ClientRep clientRep;

    public Integer saveClient(String lastName, String firstName, String patronymic, String documentType,
                         String seriesAndDocumentNumber, String dateOfBirth){
        for (String docType : permissibleValuesConfig.getDocumentTypes()) {
            if (documentType.equals(docType)) {
                return clientRep.save(new Client(lastName, firstName, patronymic, documentType,
                                          seriesAndDocumentNumber, Date.valueOf(dateOfBirth))).getId();
            }
        }
        logger.error(documentType + " document type is not supported");
        return null;
    }

    public List<Client> getClients() {
        return clientRep.findAll();
    }

    public List<Account> getAccountsOfClient(Integer id) {
        return clientRep.findById(id).get().getAccounts();
    }

    public void deleteClient(Integer id) {
        clientRep.deleteById(id);
    }
}
