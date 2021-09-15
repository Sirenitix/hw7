package com.example.BookShop.config;

import com.example.BookShop.dao.BookRepository;
import com.example.BookShop.dao.TestEntityCrudRepository;
import com.example.BookShop.entity.TestEntity;
import com.example.BookShop.entity.TestEntityDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManagerFactory;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

//    EntityManagerFactory entityManagerFactory;
//    TestEntityDao testEntityDao;

    TestEntityCrudRepository testEntityCrudRepository;
    BookRepository bookRepository;

    @Autowired
    public CommandLineRunnerImpl(TestEntityCrudRepository testEntityCrudRepository, BookRepository bookRepository) {
//        this.entityManagerFactory = entityManagerFactory;
//        this.testEntityDao = testEntityDao;
          this.testEntityCrudRepository=testEntityCrudRepository;
            this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            createTestEntity(new TestEntity());
        }

//        TestEntity readTestEntity = readTestEntityById(93);
//      TestEntity readTestEntity = testEntityDao.findOne(3);
//        if (readTestEntity != null){
//            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(readTestEntity.toString());
//        }else {
//            throw new NullPointerException();
//        }
//
////        TestEntity updateTestEntity = updateTestEntityById(93);
//        if (updateTestEntity != null){
//            Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info("update"+updateTestEntity.toString());
//        }else {
//            throw new NullPointerException();
//        }

         //deleteTestEntityById(2);
//        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.findBooksByAuthor_Firstname("Emery"));
//        Logger.getLogger(CommandLineRunnerImpl.class.getSimpleName()).info(bookRepository.customFindAllBooks().toString());
    }

    private void deleteTestEntityById(Integer id) {
//        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
//        Transaction tx = null;
//
//        try{
//            tx = session.beginTransaction();
//            TestEntity findEntity = readTestEntityById(id);
//            TestEntity mergedTestEntity = (TestEntity) session.merge(findEntity);
//            session.remove(mergedTestEntity);
//            tx.commit();
//        }catch (HibernateException hex) {
//            if (tx != null) {
//                tx.rollback();
//            } else {
//                hex.printStackTrace();
//            }
//        }finally {
//            session.close();
//        }
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntityCrudRepository.delete(testEntity);
    }

    private TestEntity updateTestEntityById(Integer id){
//        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
//        Transaction tx = null;
//        TestEntity result = null;
//
//        try{
//            tx = session.beginTransaction();
//            TestEntity findEntity = readTestEntityById(id);
//            findEntity.setData("Hmm??");
//            result = (TestEntity) session.merge(findEntity);
//            tx.commit();
//        }catch (HibernateException hex) {
//            if (tx != null) {
//                tx.rollback();
//            } else {
//                hex.printStackTrace();
//            }
//        }finally {
//            session.close();
//        }
//        return result;
        TestEntity testEntity = testEntityCrudRepository.findById(id).get();
        testEntity.setData("=)");
        testEntityCrudRepository.save(testEntity);
        return testEntity;
    }

    private TestEntity readTestEntityById(Integer id) {
//        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
//        Transaction tx = null;
//        TestEntity result = null;
//
//        try{
//            tx = session.beginTransaction();
//            result = session.find(TestEntity.class,id);
//            tx.commit();
//        }catch (HibernateException hex) {
//            if (tx != null) {
//                tx.rollback();
//            } else {
//                hex.printStackTrace();
//            }
//        }finally {
//            session.close();
//        }
//        return result;
        return testEntityCrudRepository.findById(id).get();
    }


    private void createTestEntity(TestEntity entity) {
//        Session session = entityManagerFactory.createEntityManager().unwrap(Session.class);
//        Transaction tx = null;
//
//        try{
//            tx = session.beginTransaction();
//            entity.setData(entity.getClass().getSimpleName() + entity.hashCode());
//            session.save(entity);
//            tx.commit();
//        }catch (HibernateException hex) {
//            if (tx != null) {
//                tx.rollback();
//            } else {
//                hex.printStackTrace();
//            }
//        }finally {
//            session.close();
//        }
        entity.setData(entity.getClass().getSimpleName() + entity.hashCode());
        testEntityCrudRepository.save(entity);
    }
}
