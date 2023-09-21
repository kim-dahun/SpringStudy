package com.selfstudy.springtheory.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class SingletonTypeWithProtoTypeTest {

    @Test
    void prototypeFind(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Prototypebean.class);
        Prototypebean prototypebean1 = ac.getBean(Prototypebean.class);

        prototypebean1.addCount();
        Assertions.assertThat(prototypebean1.getCount()).isEqualTo(1);

        Prototypebean prototypebean2 = ac.getBean(Prototypebean.class);
        Assertions.assertThat(prototypebean2.getCount()).isEqualTo(0);


    }


    @Test
    void singletonClientUserPrototype(){

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, Prototypebean.class);


        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);


        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(1);


    }


//    @Component
    @Scope("singleton")
    static class ClientBean {



        @Autowired
        private Provider<Prototypebean> provider;
//        private ObjectProvider<Prototypebean> provider; // 스프링에 의존하는 Provider, DL(의존성 탐색) 역할 수행

        public int logic(){
            Prototypebean prototypebean = provider.get();
            prototypebean.addCount();
            int count = prototypebean.getCount();

            return count;
        }


    }


    @Component
    @Scope("prototype")
    static class Prototypebean{

        private int count = 0;

        public void addCount(){

            this.count +=1 ;

        }

        public int getCount(){

            return count;

        }

        @PostConstruct
        public void init(){

            System.out.println("PrototypeBean.init " + this );

        }

        @PreDestroy
        public void destroy(){

            System.out.println("PrototypeBean.destroy");

        }

    }

}
