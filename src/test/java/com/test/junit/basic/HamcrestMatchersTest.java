package com.test.junit.basic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;

public class HamcrestMatchersTest {

    @Test
    void test() {

        List<Integer> scores = Arrays.asList(99,100,101,105);

        assertThat(scores, hasSize(4));
        assertThat(scores, hasItem(99));
        assertThat(scores, hasItems(101,105));
        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, everyItem(lessThan(106)));

        assertThat("", emptyString());
        assertThat(null, emptyOrNullString());

        assertThat(2 + 1, is(equalTo(3)));

        Integer marks[] = {1,2,3};
        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContaining(1,2,3));
        assertThat(marks, arrayContainingInAnyOrder(2,1,3));

    }
}
