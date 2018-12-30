package com.letsjam.business_logic.impl;

import com.letsjam.business_logic.interfaces.MusicianBL;
import com.letsjam.business_objects.enums.FilterFieldsEnum;
import com.letsjam.business_objects.web.FilterObject;
import com.letsjam.business_objects.web.TransferObject;
import com.letsjam.dao.utils.HibernateUtil;
import com.letsjam.business_objects.entities.BandEntity;
import com.letsjam.business_objects.entities.LoginEntity;
import com.letsjam.business_objects.entities.MusicianEntity;
import com.letsjam.helper.WeldJUnit4Runner;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(WeldJUnit4Runner.class)
public class MusicianBLTest extends TestCase {

    private static final transient Logger logger = LoggerFactory.getLogger(MusicianBLTest.class);

    @Inject
    private MusicianBL musicianBL;

    @Test
    public void shouldSignUp(){

        LoginEntity loginEntity1 = LoginEntity.Builder.aLoginEntity()
                .withUsername("funkysoul")
                .withPassword("napule")
                .build();

        MusicianEntity musicianEntity1 = MusicianEntity.Builder.aMusicianEntity()
                .withName("Mario")
                .withSurname("Bianchi")
                .withAge(23)
                .withCity("Massa Di Somma")
                .withMusicalInstrument("Clarinetto")
                .withEmail("mariobianchi@gmail.com")
                .withLoginEntity(loginEntity1)
                .build();

        LoginEntity loginEntity2 = LoginEntity.Builder.aLoginEntity()
                .withUsername("rockandroll")
                .withPassword("freaky1267")
                .build();

        MusicianEntity musicianEntity2 = MusicianEntity.Builder.aMusicianEntity()
                .withName("Giulia")
                .withSurname("Battindarno")
                .withAge(33)
                .withCity("Genova")
                .withMusicalInstrument("Batteria")
                .withEmail("giuletta@gmail.com")
                .withLoginEntity(loginEntity2)
                .build();

        LoginEntity loginEntity3 = LoginEntity.Builder.aLoginEntity()
                .withUsername("klarivo")
                .withPassword("blablakad")
                .build();

        MusicianEntity musicianEntity3 = MusicianEntity.Builder.aMusicianEntity()
                .withName("Karoline")
                .withSurname("Villacidro")
                .withAge(27)
                .withCity("Ercolano")
                .withMusicalInstrument("Flauto traverso")
                .withEmail("klarivo@gmail.com")
                .withLoginEntity(loginEntity3)
                .build();

        LoginEntity loginEntity4 = LoginEntity.Builder.aLoginEntity()
                .withUsername("pippo")
                .withPassword("pluto")
                .build();

        MusicianEntity musicianEntity4 = MusicianEntity.Builder.aMusicianEntity()
                .withName("Filippo")
                .withSurname("Carenzio")
                .withAge(47)
                .withCity("Poggibonsi")
                .withMusicalInstrument("Triangolo")
                .withEmail("pippomio@gmail.com")
                .withLoginEntity(loginEntity4)
                .build();

        LoginEntity loginEntity5 = LoginEntity.Builder.aLoginEntity()
                .withUsername("corbezzolo")
                .withPassword("spumeggiante56")
                .build();

        MusicianEntity musicianEntity5 = MusicianEntity.Builder.aMusicianEntity()
                .withName("Luisa")
                .withSurname("Del Caporivo")
                .withAge(23)
                .withCity("Lecco")
                .withMusicalInstrument("Ukulele")
                .withEmail("luisella@gmail.com")
                .withLoginEntity(loginEntity5)
                .build();

        musicianBL.signUp(musicianEntity1);
        musicianBL.signUp(musicianEntity2);
        musicianBL.signUp(musicianEntity3);
        musicianBL.signUp(musicianEntity4);
        musicianBL.signUp(musicianEntity5);

        logger.info("The SignUp process has succeeded!");
    }

    @Test
    public void shouldSearchAllMusicians(){

        final List<MusicianEntity> musicians = musicianBL.searchMusicians(null);

        String listOfMusicians = "The search has given this result: \n\n";

        if(!musicians.isEmpty()) {

            for (final MusicianEntity musician : musicians) {
                String musicianToString = musician.toString();
                listOfMusicians += musicianToString + "\n";
            }

            logger.info(listOfMusicians);

        } else {
            logger.warn ("The search has given 0 results");
        }
    }

    @Test
    public void shouldSearchFilteredMusiciansWithOneFilter(){

        Map<FilterFieldsEnum, String> filterFields = new HashMap<>();
        filterFields.put(FilterFieldsEnum.AGE, "23");

        FilterObject filterObject = FilterObject.Builder.aFilterObject()
                .withFilterFields(filterFields)
                .build();

        final List<MusicianEntity> musicians = musicianBL.searchMusicians(filterObject);

        String listOfMusicians = "The search has given this result: \n\n";

        if(!musicians.isEmpty()) {

            for (final MusicianEntity musician : musicians) {
                String musicianToString = musician.toString();
                listOfMusicians += musicianToString + "\n";
            }

            logger.info(listOfMusicians);

        } else {
            logger.warn ("The search has given 0 results");
        }
    }

    @Test
    public void shouldSearchFilteredMusiciansWithTwoFilters(){

        Map<FilterFieldsEnum, String> filterFields = new HashMap<>();
        filterFields.put(FilterFieldsEnum.AGE, "23");
        filterFields.put(FilterFieldsEnum.CITY, "Massa Di Somma");

        FilterObject filterObject = FilterObject.Builder.aFilterObject()
                .withFilterFields(filterFields)
                .build();

        final List<MusicianEntity> musicians = musicianBL.searchMusicians(filterObject);

        String listOfMusicians = "The search has given this result: \n\n";

        if(!musicians.isEmpty()) {

            for (final MusicianEntity musician : musicians) {
                String musicianToString = musician.toString();
                listOfMusicians += musicianToString + "\n";
            }

            logger.info(listOfMusicians);

        } else {
            logger.warn ("The search has given 0 results");
        }
    }

    @Test
    public void shouldSearchFilteredMusiciansWithThreeFilters(){

        Map<FilterFieldsEnum, String> filterFields = new HashMap<>();
        filterFields.put(FilterFieldsEnum.AGE, "23");
        filterFields.put(FilterFieldsEnum.CITY, "Massa Di Somma");
        filterFields.put(FilterFieldsEnum.MUSICAL_INSTRUMENT, "Clarinetto");

        FilterObject filterObject = FilterObject.Builder.aFilterObject()
                .withFilterFields(filterFields)
                .build();

        final List<MusicianEntity> musicians = musicianBL.searchMusicians(filterObject);

        if(!musicians.isEmpty()) {

            String listOfMusicians = "The search has given this result: \n\n";

            for (final MusicianEntity musician : musicians) {
                String musicianToString = musician.toString();
                listOfMusicians += musicianToString + "\n";
            }

            logger.info(listOfMusicians);

        } else {
            logger.warn ("The search has given 0 results");
        }
    }

    @Test
    public void shouldGetMusicianEntityFromLoginEntity(){

        LoginEntity loginEntityFromTransferObject = LoginEntity.Builder.aLoginEntity()
                .withUsername("klarivo")
                .withPassword("blablakad")
                .build();

        TransferObject<LoginEntity> loginTransferObject = TransferObject.Builder.<LoginEntity>aTransferObject()
                .withGenericData(loginEntityFromTransferObject)
                .build();

        MusicianEntity musicianEntity = musicianBL.getMusicianEntityFromLoginEntity(loginTransferObject);

        logger.info("The search has given this result: \n\n" + musicianEntity.toString());
    }

    @Test
    public void shouldUpdateMusician(){

        // Fields to update
        final String city = "Pesaro";
        final String musicalInstrument = "Clavicembalo";
        final String surname = "Di Rienzo";

        LoginEntity loginEntityFromTransferObject = LoginEntity.Builder.aLoginEntity()
                .withUsername("klarivo")
                .withPassword("blablakad")
                .build();

        TransferObject<LoginEntity> loginTransferObject = TransferObject.Builder.<LoginEntity>aTransferObject()
                .withGenericData(loginEntityFromTransferObject)
                .build();

        MusicianEntity musicianEntityToUpdate = musicianBL.getMusicianEntityFromLoginEntity(loginTransferObject);

        logger.info("Musician Entity before update: {}", musicianEntityToUpdate.toString());

        if(musicianEntityToUpdate != null) {
            MusicianEntity musicianEntityWithUpdateFields = MusicianEntity.Builder.aMusicianEntity()
                    .withId(musicianEntityToUpdate.getId())
                    .withAge(musicianEntityToUpdate.getAge())
                    .withCity(city)
                    .withEmail(musicianEntityToUpdate.getEmail())
                    .withMusicalInstrument(musicalInstrument)
                    .withName(musicianEntityToUpdate.getName())
                    .withSurname(surname)
                    .build();

            musicianBL.updateMusician(musicianEntityWithUpdateFields);
        }

        MusicianEntity musicianEntityUpdated = musicianBL.getMusicianEntityFromLoginEntity(loginTransferObject);

        logger.info("Musician Entity after update: {}", musicianEntityUpdated.toString());
    }

    @Test
    public void shouldDeleteMusician(){

        final Long id = 2L;

        musicianBL.deleteMusician(id);

        logger.info("Deletion of musician with id {} completed", id.toString());
    }


    @Test
    public void shouldSaveBand(){

        LoginEntity loginEntity = LoginEntity.Builder.aLoginEntity()
                .withUsername("salvantonio91")
                .withPassword("letsjam")
                .build();

        MusicianEntity musicianEntity = MusicianEntity.Builder.aMusicianEntity()
                .withName("Antonio")
                .withSurname("Salvatore")
                .withAge(27)
                .withCity("Torre del Greco")
                .withMusicalInstrument("Chitarra elettrica")
                .withEmail("prova@gmail.com")
                .withLoginEntity(loginEntity)
                .build();

        BandEntity bandEntity = BandEntity.Builder.aBandEntity()
                .withBandName("B-Side Funk!")
                .withMusicalGenre("Funk-Rock")
                .withMusicianEntity(musicianEntity)
                .build();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(bandEntity);
        session.getTransaction().commit();
        session.close();

        logger.info("The Band Entity has been created successfully!");
    }


}
