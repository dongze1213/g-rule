package rules

import com.whale.rule.IRule


class Rule1 implements IRule
{

    Map<String, Object> loadRules() {
        return [

                baby   : { params,predicates -> params[0].age < predicates.v1 },
                child  : { params,predicates -> params[0].age >= predicates.v1 && params[0].age < predicates.v2 },
                student: { params,predicates -> params[0].age >=  predicates.v2 && params[0].age <  predicates.v3 },
                adult  : { params,predicates -> params[0].age >= predicates.v3 && params[0].age < predicates.v4 },
                senior : { params,predicates -> params[0].age >= predicates.v4 },

                /* baby   : { params -> params[0].age < 3 },
                 child  : { params -> params[0].age >= 3 && params[0].age < 10 },
                 student: { params -> params[0].age >= 10 && params[0].age < 21 },
                 adult  : { params -> params[0].age >= 21 && params[0].age < 65 },
                 senior : { params -> params[0].age >= 65 },*/

                // We could have written the rules using the default pointer, like:
                //   child:  { it.age >=  3 && it.age < 10 }
                // But I don't like using gender neutral pronouns in this case.


        ]

    }

    Map<String, Object> loadAdmissions(){
        return  [
                isBaby   : { params,subjects->subjects.baby },
                isChild  : { params,subjects->subjects.child },
                isStudent: { params,subjects->subjects.student  },
                isSenior : { params,subjects->subjects.senior },
                isAdult  : { params,subjects->subjects.adult }

               /* isBaby   : { 0.00 },
                isChild  : { 3.00 },
                isStudent: { 7.00 },
                isSenior : { 7.00 },
                isAdult  : { 9.00 }*/
        ]
    }
}



