package com.whale.rule

import com.whale.RuleApplication
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Component
import org.springframework.test.context.web.WebAppConfiguration


@SpringBootTest(classes = RuleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class demoTest extends GroovyTestCase {
    @Autowired
    RuleLoader loader

    void testTest() {
        def bob =( [ name:'Bob Barker', age:2 ] )
      //  RuleLoader loader =new RuleLoader("src/main/resources/rules/")

        RuleRunner runner =new RuleRunner(loader.load("Rule1"))

        def predicates = [
                v1   :  3 ,
                v2  : 10,
                v3: 21 ,
                v4 : 65,
    ]


        def subjects = [
                baby   : 0.00 ,
                child  :  3.00 ,
                student:  7.00 ,
                senior :  7.00 ,
                adult  :  9.00,
        ]
        print(predicates.v1)
        print(subjects.baby)

       Object r= runner.run(predicates,subjects,bob,bob)
        print(r)
    }
}
