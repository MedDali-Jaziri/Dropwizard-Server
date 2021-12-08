package main;

import Controller.UserController;
import DAO.UserDAO;
import Entity.User;
import config.DropWizardConfiguration;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizard_App extends Application<DropWizardConfiguration> {
    public static void main(String[] args) throws Exception{
        new DropWizard_App().run(args);
    }
    @Override
    public void run(DropWizardConfiguration dropWizardConfiguration, Environment environment) throws Exception {
        System.out.println("Hello Bool !!");
        UserDAO bookDAO = new UserDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new UserController(bookDAO));
    }

    HibernateBundle<DropWizardConfiguration> hibernateBundle = new HibernateBundle<DropWizardConfiguration>(User.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(DropWizardConfiguration dropWizardConfiguration) {
            return dropWizardConfiguration.getDataSourceFactory();
        }
    };


    @Override
    public void initialize(Bootstrap<DropWizardConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }
}
