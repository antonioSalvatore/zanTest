package com.letsjam.business_logic.impl;

import com.letsjam.business_logic.interfaces.LoginBL;
import com.letsjam.business_logic.interfaces.MusicianBL;
import com.letsjam.business_objects.entities.LoginEntity;
import com.letsjam.business_objects.entities.MusicianEntity;
import com.letsjam.business_objects.enums.FilterFieldsEnum;
import com.letsjam.business_objects.enums.StatusEnum;
import com.letsjam.business_objects.web.FilterObject;
import com.letsjam.business_objects.web.GenericResult;
import com.letsjam.business_objects.web.TransferObject;
import com.letsjam.dao.impl.MusicianDAOImpl;
import com.letsjam.dao.interfaces.MusicianDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Map;

public class MusicianBLImpl implements MusicianBL {

    private static final transient Logger logger = LoggerFactory.getLogger(MusicianBLImpl.class);

    private static final String ENTITY = "MusicianEntity";
    private static final String ALIAS = "m";

    /*private MusicianDAOImpl musicianDAO = new MusicianDAOImpl();*/
    @Inject
    private MusicianDAOImpl musicianDAO;

    /*private LoginBLImpl loginBL = new LoginBLImpl();*/
    @Inject
    private LoginBLImpl loginBL;

    @Override
    public GenericResult<StatusEnum, MusicianEntity> signUp(final MusicianEntity musicianEntity){

        logger.info("call signUp()");

        GenericResult<StatusEnum, MusicianEntity> genericResult;

        try {
            musicianDAO.saveMusician(musicianEntity);

            genericResult = GenericResult.Builder.<StatusEnum, MusicianEntity>aGenericResult()
                    .withStatus(StatusEnum.OK)
                    .withGenericData(musicianEntity)
                    .build();
        } catch (PersistenceException ex){
            logger.error("Username already in use!");

            genericResult = GenericResult.Builder.<StatusEnum, MusicianEntity>aGenericResult()
                    .withStatus(StatusEnum.KO_ALREADY_EXISTS)
                    .withGenericData(musicianEntity)
                    .build();
        }

        return genericResult;
    }

    @Override
    public GenericResult<StatusEnum, MusicianEntity> searchMusicians(final FilterObject filterObject){

        logger.info("call searchMusicians()");

        GenericResult<StatusEnum, MusicianEntity> genericResult = GenericResult.Builder.<StatusEnum, MusicianEntity>aGenericResult()
                .withStatus(StatusEnum.KO)
                .build();

        // Initialize the query string
        String query = FROM_CLAUSE + " " + ENTITY + " " + ALIAS + " ";

        if (filterObject != null){

            // Get the map containing the filter fields
            final Map<String, String> filterFields = filterObject.getFilterFields();

            // If the map is not empty, it means that at least one filter exists
            if(filterFields != null && !filterFields.isEmpty()){

                // Initialize a boolean in order to notify that at least one filter exists and it's possible
                // to add the "AND" clause in the query if there are other filters
                boolean filterExists = false;

                // Create the query dynamically, based on the fields filled in the front end mask
                for(FilterFieldsEnum filterFieldsEnum : FilterFieldsEnum.values()){
                    final String filterFieldValue = filterFields.get(filterFieldsEnum.getDescription());
                    if(filterFieldValue != null && !filterFieldValue.isEmpty()){

                        if(!filterExists)
                            query += WHERE_CLAUSE + " ";

                        else
                            query += AND_CLAUSE + " ";

                        String column = ALIAS + "." + filterFieldsEnum.getDescription();
                        query += column + " " + EQUALS_SYMBOL + " '" + filterFieldValue + "' ";

                        filterExists = true;
                    }
                }
            }
        }

        query += ORDER_BY_CLAUSE + " " + ALIAS + ".surname ASC";

        List<MusicianEntity> musiciansList = null;
        try {
            // Execute the query and return the result
            musiciansList = musicianDAO.searchMusicians(query);

            genericResult = GenericResult.Builder.<StatusEnum, MusicianEntity>aGenericResult()
                    .withStatus(StatusEnum.OK)
                    .withGenericData(musiciansList)
                    .build();

        } catch (Exception e) {
            logger.error("There's been an error!");
        }

        return genericResult;

    }

    @Override
    public GenericResult<StatusEnum, MusicianEntity> getMusicianEntityFromLoginEntity(final TransferObject<LoginEntity> loginTransferObject){

        logger.info("call getMusicianEntityFromLoginEntity()");

        GenericResult<StatusEnum, MusicianEntity> genericResult = GenericResult.Builder.<StatusEnum, MusicianEntity>aGenericResult()
                .withStatus(StatusEnum.KO)
                .build();

        try {
            final LoginEntity loginEntity = loginBL.getLoginEntityFromUsernameAndPassword(loginTransferObject);

            if(loginEntity != null){

                final MusicianEntity musicianEntity = loginEntity.getMusicianEntity();

                genericResult = GenericResult.Builder.<StatusEnum, MusicianEntity>aGenericResult()
                        .withStatus(StatusEnum.OK)
                        .withGenericData(musicianEntity)
                        .build();
            } else {
                genericResult = GenericResult.Builder.<StatusEnum, MusicianEntity>aGenericResult()
                        .withStatus(StatusEnum.OK)
                        .build();
            }
        } catch (Exception e) {
            logger.error("There's been an error!");
        }

        return genericResult;
    }

    @Override
    public GenericResult<StatusEnum, MusicianEntity> updateMusician(final MusicianEntity musicianEntityWithUpdatedFields){

        logger.info("call updateMusician()");

        GenericResult<StatusEnum, MusicianEntity> genericResult = GenericResult.Builder.<StatusEnum, MusicianEntity>aGenericResult()
                .withStatus(StatusEnum.KO)
                .build();

        final Long musicianToUpdateId = musicianEntityWithUpdatedFields.getId();

        try {
            musicianDAO.updateMusician(musicianEntityWithUpdatedFields, musicianToUpdateId);

            final MusicianEntity musicianEntityUpdated = getMusicianById(musicianToUpdateId);

            genericResult = GenericResult.Builder.<StatusEnum, MusicianEntity>aGenericResult()
                    .withStatus(StatusEnum.OK)
                    .withGenericData(musicianEntityUpdated)
                    .build();

        } catch (Exception e) {
            logger.error("There's been an error during the update of the musician entity!");
        }

        return genericResult;
    }

    @Override
    public void deleteMusician(final Long id){

        logger.info("call deleteMusician()");

        musicianDAO.deleteMusician(id);
    }

    @Override
    public MusicianEntity getMusicianById(final Long id) throws Exception {

        logger.info("call getMusicianById()");

        return musicianDAO.getMusicianById(id);
    }
}
