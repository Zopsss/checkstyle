package com.google.checkstyle.test.chapter4formatting.rule4821onevariableperline;

public class InputOneVariablePerDeclaration
{
    int i, j; // violation 'Each variable declaration must be in its own statement.'
    int i1; int j1; // violation 'Only one variable definition per line allowed.'

    void method1() {
        String str, str1; // violation 'Each variable declaration must be in its own statement.'
        java.lang.Object obj; Object obj1;
        // violation above 'Only one variable definition per line allowed.'
    }
    // second definition is wrapped
    // line of VARIABLE_DEF is not the same as first line of the definition
    java.lang.String string; java.lang.String
    // violation above 'Only one variable definition per line allowed.'
        strings[];
    //both definitions are wrapped
    java.lang. // violation 'Only one variable definition per line allowed.'
        String string1; java.lang.String
            strings1[];

    void method2() {
        for (int i=0, j=0; i < 10; i++, j--) { //ok
        }

        for(int i=0; i<4;i++) {

        }
    }

    class Inner {
        int i, j; // violation 'Each variable declaration must be in its own statement.'
        int i1; int j1; // violation 'Only one variable definition per line allowed.'

        void method1() {
            String str, str1;
            // violation above 'Each variable declaration must be in its own statement.'
            java.lang.Object obj; Object obj1;
            // violation above 'Only one variable definition per line allowed.'
        }
        // second definition is wrapped
        // line of VARIABLE_DEF is not the same as first line of the definition
        java.lang.String string; java.lang.String
        // violation above 'Only one variable definition per line allowed.'
            strings[];
        //both definitions are wrapped
        java.lang. // violation 'Only one variable definition per line allowed.'
            String string1; java.lang.String
                strings1[];

        void method2() {
            for (int i=0, j=0; i < 10; i++, j--) { //ok
            }

            for(int i=0; i<4;i++) {

            }
        }
        Inner anon = new Inner()
        {
            int i, j; // violation 'Each variable declaration must be in its own statement.'
            int i1; int j1; // violation 'Only one variable definition per line allowed.'

            void method1() {
                String str, str1;
                // violation above 'Each variable declaration must be in its own statement.'
                java.lang.Object obj; Object obj1;
                // violation above 'Only one variable definition per line allowed.'
            }
            // second definition is wrapped
            // line of VARIABLE_DEF is not the same as first line of the definition
            java.lang.String string; java.lang.String
            // violation above 'Only one variable definition per line allowed.'
                strings[];
            //both definitions are wrapped
            java.lang. // violation 'Only one variable definition per line allowed.'
                String string1; java.lang.String
                    strings1[];

            void method2() {
                for (int i=0, j=0; i < 10; i++, j--) { //ok
                }

                for(int i=0; i<4;i++) {

                }
            }
        };
    }
}

class Suppress {
    @SuppressWarnings("unused")
    // violation above 'Each variable declaration must be in its own statement.'
    long q1, q2, q3;

    @SuppressWarnings("unused") long q4, q5, q6;
    // violation above 'Each variable declaration must be in its own statement.'
}
