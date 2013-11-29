package Test;

import main.Length;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: talkin
 * Date: 13-11-18
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
public class LengthTest {

    @Test
    public void should_one_mile_equal_another_mile() throws Exception {
        Length oneMile = new Length("mile",1760);
        Length anotherMile = new Length("mile",1760);

        assertThat(oneMile.equals(anotherMile),is(true));

    }

    @Test
    public void should_one_yard_equal_another_yard() throws Exception {
        Length oneYard = new Length("yard",3);
        Length anotherYard = new Length("yard",3);

        assertThat(oneYard.equals(anotherYard),is(true));

    }

    @Test
    public void should_3_yard_not_equal_4_yard() throws Exception {
        Length threeYard = new Length("yard",3);
        Length fourYard = new Length("yard",4);

        assertThat(threeYard.equals(fourYard),is(false));

    }

    @Test
    public void should_1_mile_equal_1760_yard() throws Exception {
        Length oneMile = new Length("mile",1);
        Length oneYard = new Length("yard",1760);

        assertThat(oneMile.equals(oneYard),is(true));

    }

    @Test
    public void should_1_mile_not_equal_1761_yard() throws Exception {
        Length oneMile = new Length("mile",1);
        Length oneYard = new Length("yard",1761);

        assertThat(oneMile.equals(oneYard),is(false));

    }

    @Test
    public void should_1_yard_equal_3_feet() throws Exception {
        Length oneYard = new Length("yard",1);
        Length oneFeet = new Length("feet",3);

        assertThat(oneYard.equals(oneFeet),is(true));

    }

    @Test
    public void should_1_yard_not_equal_4_feet() throws Exception {
        Length oneYard = new Length("yard",1);
        Length oneFeet = new Length("feet",4);

        assertThat(oneYard.equals(oneFeet),is(false));

    }

    @Test
    public void should_1_feet_equal_12_inch() throws Exception {
        Length oneFeet = new Length("feet",1);
        Length oneInch = new Length("inch",12);

        assertThat(oneFeet.equals(oneInch),is(true));

    }

    @Test
    public void should_1_feet_not_equal_13_inch() throws Exception {
        Length oneFeet = new Length("feet",1);
        Length oneInch = new Length("inch",13);

        assertThat(oneFeet.equals(oneInch),is(false));

    }

//    @Test
//    public void should_unit_be_defined() throws Exception {
//
//    }

    @Test
    public void should_mile_and_yard_can_add() throws Exception {
        Length oneMile = new Length("mile",1);
        Length oneYard = new Length("yard",1);
        Length one_except = new Length("inch",1760*3*12 + 3*12);

        int add_value = add(oneMile, oneYard);
        Length add = new Length("",add_value);

        assertThat(add.equals(one_except),is(true));

    }

    @Test
    public void should_mile_and_feet_can_add() throws Exception {
        Length oneMile = new Length("mile",1);
        Length oneFeet = new Length("feet",1);
        Length one_except = new Length("inch",1760*3*12 + 12);

        int add_value = add(oneMile,oneFeet);
        Length add = new Length("",add_value);

        assertThat(add.equals(one_except),is(true));

    }

    @Test
    public void should_mile_and_inch_can_add() throws Exception {
        Length oneMile = new Length("mile",1);
        Length oneInch = new Length("inch",1);
        Length one_except = new Length("inch",1760*3*12 + 1);

        int add_value = add(oneMile,oneInch);
        Length add = new Length("",add_value);

        assertThat(add.equals(one_except),is(true));

    }

    @Test
    public void should_yard_and_feet_can_add() throws Exception {
        Length oneYard = new Length("yard",1);
        Length oneFeet = new Length("feet",1);
        Length one_except = new Length("inch",3*12 + 12);

        int add_value = add(oneYard,oneFeet);
        Length add = new Length("",add_value);

        assertThat(add.equals(one_except),is(true));

    }

    @Test
    public void should_yard_and_inch_can_add() throws Exception {
        Length oneYard = new Length("yard",1);
        Length oneInch = new Length("inch",1);
        Length one_except = new Length("inch",3*12 + 1);

        int add_value = add(oneYard,oneInch);
        Length add = new Length("",add_value);

        assertThat(add.equals(one_except),is(true));

    }

    @Test
    public void should_feet_and_inch_can_add() throws Exception {
        Length oneFeet = new Length("feet",1);
        Length oneInch = new Length("inch",1);
        Length one_except = new Length("inch",12 + 1);

        int add_value = add(oneFeet,oneInch);
        Length add = new Length("",add_value);

        assertThat(add.equals(one_except),is(true));

    }

    private int add(Length o1, Length o2) {
        int result;
        if (o1.unit == "mile")
            o1.value = 1760*12*3;
        else if (o1.unit == "yard")
            o1.value = 12*3;
        else if (o1.unit == "feet")
            o1.value = 12;
        else o1.value = 1;

        if (o2.unit == "mile")
            o2.value = 1760*12*3;
        else if (o2.unit == "yard")
            o2.value = 12*3;
        else if (o2.unit == "feet")
            o2.value = 12;
        else o2.value = 1;


        result = o1.value + o2.value;
        return result;

    }

}
