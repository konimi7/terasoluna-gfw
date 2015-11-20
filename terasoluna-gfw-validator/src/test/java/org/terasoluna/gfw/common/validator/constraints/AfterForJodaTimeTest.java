/*
 * Copyright (C) 2013-2015 terasoluna.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.terasoluna.gfw.common.validator.constraints;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.YearMonth;
import org.junit.Before;
import org.junit.Test;
import org.terasoluna.gfw.common.validator.constraints.AfterForJodaTimeTest.AfterForJodaTimeTestForm;

/**
 * Test class of {@link After} for Joda-Time
 */
public class AfterForJodaTimeTest
                                 extends
                                 AbstractConstraintsTest<AfterForJodaTimeTestForm> {

    private static final String MESSAGE_VALIDATION_ERROR = "must be after %s";

    @Before
    public void before() {
        form = new AfterForJodaTimeTestForm();
    }

    /**
     * for {@link DateTime} property. specify value. expected valid if input value is after(grater than) value.
     * @throws Throwable
     */
    @Test
    public void testSpecifyValueForDateTime() throws Throwable {

        {
            form.setDateTimeProperty(DateTime.parse("2015-10-01T00:00:00"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "2015-10-01T00:00:00")));
        }

        {
            form.setDateTimeProperty(DateTime.parse("2015-10-02T00:00:00"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link DateTime} property. specify format. expected valid if input value is after(grater than) value parsed specified
     * format.
     * @throws Throwable
     */
    @Test
    public void testSpecifyFormatForDateTime() throws Throwable {

        {
            form.setDateTimeProperty(DateTime.parse("2015-10-01T00:00:00"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "2015年10月01日00時00分00秒")));
        }

        {
            form.setDateTimeProperty(DateTime.parse("2015-10-02T00:00:00"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link DateTime} property. specify illegal format and value. expected {@code ValidationException} caused by
     * {@code IllegalArgumentException} that message is {@code failed to initialize validator by invalid argument}.
     * @throws Throwable
     */
    @Test
    public void testSpecifyIllegalFormatForDateTime() throws Throwable {
        setExpectedFailedToInitialize(IllegalArgumentException.class);

        form.setDateTimeProperty(DateTime.parse("2015-10-01T00:00:00"));

        validator.validate(form, IllegalFormat.class);
    }

    /**
     * for {@link LocalDate} property. specify value. expected valid if input value is after(grater than) value.
     * @throws Throwable
     */
    @Test
    public void testSpecifyValueForLocalDate() throws Throwable {

        {
            form.setLocalDateProperty(LocalDate.parse("2015-10-01"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "2015-10-01")));
        }

        {
            form.setLocalDateProperty(LocalDate.parse("2015-10-02"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link LocalDate} property. specify format. expected valid if input value is after(grater than) value parsed
     * specified format.
     * @throws Throwable
     */
    @Test
    public void testSpecifyFormatForLocalDate() throws Throwable {

        {
            form.setLocalDateProperty(LocalDate.parse("2015-10-01"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "2015年10月01日")));
        }

        {
            form.setLocalDateProperty(LocalDate.parse("2015-10-02"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link LocalDate} property. specify illegal format and value. expected {@code ValidationException} caused by
     * {@code IllegalArgumentException} that message is {@code failed to initialize validator by invalid argument}.
     * @throws Throwable
     */
    @Test
    public void testSpecifyIllegalFormatForLocalDate() throws Throwable {
        setExpectedFailedToInitialize(IllegalArgumentException.class);

        form.setLocalDateProperty(LocalDate.parse("2015-10-01"));

        validator.validate(form, IllegalFormat.class);
    }

    /**
     * for {@link LocalDateTime} property. specify value. expected valid if input value is after(grater than) value.
     * @throws Throwable
     */
    @Test
    public void testSpecifyValueForLocalDateTime() throws Throwable {

        {
            form.setLocalDateTimeProperty(LocalDateTime
                    .parse("2015-10-01T00:00:00"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "2015-10-01T00:00:00")));
        }

        {
            form.setLocalDateTimeProperty(LocalDateTime
                    .parse("2015-10-02T00:00:00"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link LocalDateTime} property. specify format. expected valid if input value is after(grater than) value parsed
     * specified format.
     * @throws Throwable
     */
    @Test
    public void testSpecifyFormatForLocalDateTime() throws Throwable {

        {
            form.setLocalDateTimeProperty(LocalDateTime
                    .parse("2015-10-01T00:00:00"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "2015年10月01日00時00分00秒")));
        }

        {
            form.setLocalDateTimeProperty(LocalDateTime
                    .parse("2015-10-02T00:00:00"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link LocalDateTime} property. specify illegal format and value. expected {@code ValidationException} caused by
     * {@code IllegalArgumentException} that message is {@code failed to initialize validator by invalid argument}.
     * @throws Throwable
     */
    @Test
    public void testSpecifyIllegalFormatForLocalDateTime() throws Throwable {
        setExpectedFailedToInitialize(IllegalArgumentException.class);

        form.setLocalDateTimeProperty(LocalDateTime
                .parse("2015-10-01T00:00:00"));

        validator.validate(form, IllegalFormat.class);
    }

    /**
     * for {@link LocalTime} property. specify value. expected valid if input value is after(grater than) value.
     * @throws Throwable
     */
    @Test
    public void testSpecifyValueForLocalTime() throws Throwable {

        {
            form.setLocalTimeProperty(LocalTime.parse("15:10:01"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "T15:10:01")));
        }

        {
            form.setLocalTimeProperty(LocalTime.parse("15:10:02"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link LocalTime} property. specify format. expected valid if input value is after(grater than) value parsed
     * specified format.
     * @throws Throwable
     */
    @Test
    public void testSpecifyFormatForLocalTime() throws Throwable {

        {
            form.setLocalTimeProperty(LocalTime.parse("15:10:01"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "15時10分01秒")));
        }

        {
            form.setLocalTimeProperty(LocalTime.parse("15:10:02"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link LocalTime} property. specify illegal format and value. expected {@code ValidationException} caused by
     * {@code IllegalArgumentException} that message is {@code failed to initialize validator by invalid argument}.
     * @throws Throwable
     */
    @Test
    public void testSpecifyIllegalFormatForLocalTime() throws Throwable {
        setExpectedFailedToInitialize(IllegalArgumentException.class);

        form.setLocalTimeProperty(LocalTime.parse("15:10:01"));

        validator.validate(form, IllegalFormat.class);
    }

    /**
     * for {@link YearMonth} property. specify value. expected valid if input value is after(grater than) value.
     * @throws Throwable
     */
    @Test
    public void testSpecifyValueForYear() throws Throwable {

        {
            form.setYearProperty(YearMonth.parse("2015"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "2015")));
        }

        {
            form.setYearProperty(YearMonth.parse("2016"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link YearMonth} property. specify format. expected valid if input value is after(grater than) value parsed
     * specified format.
     * @throws Throwable
     */
    @Test
    public void testSpecifyFormatForYear() throws Throwable {

        {
            form.setYearProperty(YearMonth.parse("2015"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "2015年")));
        }

        {
            form.setYearProperty(YearMonth.parse("2016"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link YearMonth} property. specify illegal format and value. expected {@code ValidationException} caused by
     * {@code IllegalArgumentException} that message is {@code failed to initialize validator by invalid argument}.
     * @throws Throwable
     */
    @Test
    public void testSpecifyIllegalFormatForYear() throws Throwable {
        setExpectedFailedToInitialize(IllegalArgumentException.class);

        form.setYearProperty(YearMonth.parse("2015"));

        validator.validate(form, IllegalFormat.class);
    }

    /**
     * for {@link YearMonth} property. specify value. expected valid if input value is after(grater than) value.
     * @throws Throwable
     */
    @Test
    public void testSpecifyValueForYearMonth() throws Throwable {

        {
            form.setYearMonthProperty(YearMonth.parse("2015-10"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "2015-10")));
        }

        {
            form.setYearMonthProperty(YearMonth.parse("2015-11"));

            violations = validator.validate(form);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link YearMonth} property. specify format. expected valid if input value is after(grater than) value parsed
     * specified format.
     * @throws Throwable
     */
    @Test
    public void testSpecifyFormatForYearMonth() throws Throwable {

        {
            form.setYearMonthProperty(YearMonth.parse("2015-10"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(1));
            assertThat(violations.iterator().next().getMessage(), is(String
                    .format(MESSAGE_VALIDATION_ERROR, "2015年10月")));
        }

        {
            form.setYearMonthProperty(YearMonth.parse("2015-11"));

            violations = validator.validate(form, SpecifyFormat.class);
            assertThat(violations.size(), is(0));
        }
    }

    /**
     * for {@link YearMonth} property. specify illegal format and value. expected {@code ValidationException} caused by
     * {@code IllegalArgumentException} that message is {@code failed to initialize validator by invalid argument}.
     * @throws Throwable
     */
    @Test
    public void testSpecifyIllegalFormatForYearMonth() throws Throwable {
        setExpectedFailedToInitialize(IllegalArgumentException.class);

        form.setYearMonthProperty(YearMonth.parse("2015-10"));

        validator.validate(form, IllegalFormat.class);
    }

    /**
     * Validation group japanese format.
     */
    private static interface SpecifyFormat {
    };

    /**
     * Validation group invalid format.
     */
    private static interface IllegalFormat {
    };

    public class AfterForJodaTimeTestForm {
        @After.List({
                @After("2015-10-01T00:00:00"),
                @After(value = "2015年10月01日00時00分00秒", format = "yyyy年MM月dd日HH時mm分ss秒", groups = { SpecifyFormat.class }),
                @After(value = "2015-10-01T00:00:00", format = "yyyy年MM月dd日HH時mm分ss秒", groups = { IllegalFormat.class }) })
        private DateTime dateTimeProperty;

        @After.List({
                @After("2015-10-01"),
                @After(value = "2015年10月01日", format = "yyyy年MM月dd日", groups = { SpecifyFormat.class }),
                @After(value = "2015-10-01", format = "yyyy年MM月dd日", groups = { IllegalFormat.class }) })
        private LocalDate localDateProperty;

        @After.List({
                @After("2015-10-01T00:00:00"),
                @After(value = "2015年10月01日00時00分00秒", format = "yyyy年MM月dd日HH時mm分ss秒", groups = { SpecifyFormat.class }),
                @After(value = "2015-10-01T00:00:00", format = "yyyy年MM月dd日HH時mm分ss秒", groups = { IllegalFormat.class }) })
        private LocalDateTime localDateTimeProperty;

        @After.List({
                @After("T15:10:01"),
                @After(value = "15時10分01秒", format = "HH時mm分ss秒", groups = { SpecifyFormat.class }),
                @After(value = "T15:10:01", format = "HH時mm分ss秒", groups = { IllegalFormat.class }) })
        private LocalTime localTimeProperty;

        @After.List({
                @After("2015"),
                @After(value = "2015年", format = "yyyy年", groups = { SpecifyFormat.class }),
                @After(value = "2015", format = "yyyy年", groups = { IllegalFormat.class }) })
        private YearMonth yearProperty;

        @After.List({
                @After("2015-10"),
                @After(value = "2015年10月", format = "yyyy年MM月", groups = { SpecifyFormat.class }),
                @After(value = "2015-10", format = "yyyy年MM月", groups = { IllegalFormat.class }) })
        private YearMonth yearMonthProperty;

        public DateTime getDateTimeProperty() {
            return dateTimeProperty;
        }

        public void setDateTimeProperty(DateTime dateTimeProperty) {
            this.dateTimeProperty = dateTimeProperty;
        }

        public LocalDate getLocalDateProperty() {
            return localDateProperty;
        }

        public void setLocalDateProperty(LocalDate localDateProperty) {
            this.localDateProperty = localDateProperty;
        }

        public LocalDateTime getLocalDateTimeProperty() {
            return localDateTimeProperty;
        }

        public void setLocalDateTimeProperty(LocalDateTime localDateTimeProperty) {
            this.localDateTimeProperty = localDateTimeProperty;
        }

        public LocalTime getLocalTimeProperty() {
            return localTimeProperty;
        }

        public void setLocalTimeProperty(LocalTime localTimeProperty) {
            this.localTimeProperty = localTimeProperty;
        }

        public YearMonth getYearProperty() {
            return yearProperty;
        }

        public void setYearProperty(YearMonth yearProperty) {
            this.yearProperty = yearProperty;
        }

        public YearMonth getYearMonthProperty() {
            return yearMonthProperty;
        }

        public void setYearMonthProperty(YearMonth yearMonthProperty) {
            this.yearMonthProperty = yearMonthProperty;
        }
    }
}