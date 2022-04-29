package com.wonen.common;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

public class Convert {
    private Convert() {
    }

    public static <C> C toClass(Object value, Class<C> type) {
        if (value == null){
            return null;
        }
        if (type.isInstance(value)) {
            return (C) value;
        }else if (value instanceof String){
            C resp;
            try{
                Constructor<?> cons = type.getConstructor(String.class);
                resp = (C) cons.newInstance(value.toString());
            } catch (Exception e) {
                resp = null;
            }
            return resp;
        }else{
            return null;
        }

    }
    public static <C> C toClass(Object value, Class<C> type, Object nullValue) {
        C resp = toClass(value, type);
        return (resp!=null ? resp : toClass(nullValue, type));
    }

    //BigInteger
    public static BigInteger toBigInteger(String value) {
        return toBigInteger(value, BigInteger.ZERO);
    }
    public static BigInteger toBigInteger(String value, BigInteger nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return new BigInteger(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigInteger toBigInteger(Long value) {
        return toBigInteger(value, BigInteger.ZERO);
    }
    public static BigInteger toBigInteger(Long value, BigInteger nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return BigInteger.valueOf(value.longValue());
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigInteger toBigInteger(long value) {
        return toBigInteger(value, BigInteger.ZERO);
    }
    public static BigInteger toBigInteger(long value, BigInteger nullValue) {
        try{
            return BigInteger.valueOf(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigInteger toBigInteger(Double value) {
        return toBigInteger(value, BigInteger.ZERO);
    }
    public static BigInteger toBigInteger(Double value, BigInteger nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return toBigDecimal(value).toBigInteger();
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigInteger toBigInteger(double value) {
        return toBigInteger(value, BigInteger.ZERO);
    }
    public static BigInteger toBigInteger(double value, BigInteger nullValue) {
        try{
            return toBigDecimal(value).toBigInteger();
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigInteger toBigInteger(Integer value) {
        return toBigInteger(value, BigInteger.ZERO);
    }
    public static BigInteger toBigInteger(Integer value, BigInteger nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return BigInteger.valueOf(value.longValue());
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigInteger toBigInteger(int value) {
        return toBigInteger(value, BigInteger.ZERO);
    }
    public static BigInteger toBigInteger(int value, BigInteger nullValue) {
        try{
            return BigInteger.valueOf((long) value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigInteger toBigInteger(BigDecimal value) {
        return toBigInteger(value, BigInteger.ZERO);
    }
    public static BigInteger toBigInteger(BigDecimal value, BigInteger nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return value.toBigInteger();
        } catch (Exception e) {
            return nullValue;
        }
    }

    //BigDecimal
    public static BigDecimal toBigDecimal(String value) {
        return toBigDecimal(value, BigDecimal.ZERO);
    }
    public static BigDecimal toBigDecimal(String value, BigDecimal nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return new BigDecimal(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigDecimal toBigDecimal(Long value) {
        return toBigDecimal(value, BigDecimal.ZERO);
    }
    public static BigDecimal toBigDecimal(Long value, BigDecimal nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return BigDecimal.valueOf(value.longValue());
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigDecimal toBigDecimal(long value) {
        return toBigDecimal(value, BigDecimal.ZERO);
    }
    public static BigDecimal toBigDecimal(long value, BigDecimal nullValue) {
        try{
            return BigDecimal.valueOf(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigDecimal toBigDecimal(Double value) {
        return toBigDecimal(value, BigDecimal.ZERO);
    }
    public static BigDecimal toBigDecimal(Double value, BigDecimal nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return BigDecimal.valueOf(value.doubleValue());
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigDecimal toBigDecimal(double value) {
        return toBigDecimal(value, BigDecimal.ZERO);
    }
    public static BigDecimal toBigDecimal(double value, BigDecimal nullValue) {
        try{
            return BigDecimal.valueOf(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigDecimal toBigDecimal(Integer value) {
        return toBigDecimal(value, BigDecimal.ZERO);
    }
    public static BigDecimal toBigDecimal(Integer value, BigDecimal nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return BigDecimal.valueOf(value.longValue());
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigDecimal toBigDecimal(int value) {
        return toBigDecimal(value, BigDecimal.ZERO);
    }
    public static BigDecimal toBigDecimal(int value, BigDecimal nullValue) {
        try{
            return BigDecimal.valueOf((long)value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static BigDecimal toBigDecimal(BigInteger value) {
        return toBigDecimal(value, BigDecimal.ZERO);
    }
    public static BigDecimal toBigDecimal(BigInteger value, BigDecimal nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return new BigDecimal(value);
        } catch (Exception e) {
            return nullValue;
        }
    }

    //primitives / Object from String
    public static Byte toByte(String value) {
        return toByte(value, Byte.valueOf("0"));
    }
    public static Byte toByte(String value, Byte nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Byte.valueOf(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static byte tobyte(String value) {
        return tobyte(value, (byte)0);
    }
    public static byte tobyte(String value, byte nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Byte.parseByte(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static Short toShort(String value) {
        return toShort(value, Short.valueOf("0"));
    }
    public static Short toShort(String value, Short nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Short.valueOf(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static short toshort(String value) {
        return toshort(value, (short)0);
    }
    public static short toshort(String value, short nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Short.parseShort(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static Integer toInteger(String value) {
        return toInteger(value, Integer.valueOf("0"));
    }
    public static Integer toInteger(String value, Integer nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Integer.valueOf(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static int toint(String value) {
        return toint(value, 0);
    }
    public static int toint(String value, int nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Integer.parseInt(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static Long toLong(String value) {
        return toLong(value, Long.valueOf("0"));
    }
    public static Long toLong(String value, Long nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Long.valueOf(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static long tolong(String value) {
        return tolong(value, 0L);
    }
    public static long tolong(String value, Long nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Long.parseLong(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static Float toFloat(String value) {
        return toFloat(value, Float.valueOf("0.0"));
    }
    public static Float toFloat(String value, Float nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Float.valueOf(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static float tofloat(String value) {
        return tofloat(value, 0.0F);
    }
    public static float tofloat(String value, float nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Float.parseFloat(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static Double toDouble(String value) {
        return toDouble(value, Double.valueOf("0.0"));
    }
    public static Double toDouble(String value, Double nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Double.valueOf(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static double todouble(String value) {
        return todouble(value, 0.0);
    }
    public static double todouble(String value, double nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Double.parseDouble(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static Boolean toBoolean(String value) {
        return toBoolean(value, Boolean.valueOf("false"));
    }
    public static Boolean toBoolean(String value, Boolean nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Boolean.valueOf(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static boolean toboolean(String value) {
        return toboolean(value, false);
    }
    public static boolean toboolean(String value, boolean nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Boolean.parseBoolean(value);
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static Character toCharacter(String value) {
        return toCharacter(value, Character.valueOf('\u0000'));
    }
    public static Character toCharacter(String value, Character nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return Character.valueOf(value.charAt(0));
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static char tochar(String value) {
        return tochar(value, '\u0000');
    }
    public static char tochar(String value, char nullValue) {
        if (value == null){
            return nullValue;
        }
        try{
            return value.charAt(0);
        } catch (Exception e) {
            return nullValue;
        }
    }

    //Date
    public static java.util.Date toDate(LocalDate localDate) {
        return toDate(localDate, null);
    }
    public static java.util.Date toDate(LocalDate localDate, java.util.Date nullValue) {
        if (localDate == null){
            return nullValue;
        }
        try{
            return java.util.Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static java.util.Date toDate(LocalDateTime localDateTime) {
        return toDate(localDateTime, null);
    }
    public static java.util.Date toDate(LocalDateTime localDateTime, java.util.Date nullValue) {
        if (localDateTime == null){
            return nullValue;
        }
        try{
            return java.util.Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static java.util.Date toDate(String date, String format) {
        return toDate(date, format, null);
    }
    public static java.util.Date toDate(String date, String format, java.util.Date nullValue) {
        if (date == null){
            return nullValue;
        }
        if (format == null){
            format = "dd/MM/yyyy";
        }
        try{
            SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
            formatter.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
            return formatter.parse(date);
        } catch (Exception e) {
            return nullValue;
        }
    }

    //LocalDate
    public static LocalDate toLocalDate(java.util.Date date) {
        return toLocalDate(date, null);
    }
    public static LocalDate toLocalDate(java.util.Date date, LocalDate nullValue) {
        if (date == null){
            return nullValue;
        }
        try{
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static LocalDate toLocalDate(String date, String format) {
        return toLocalDate(date, format, null);
    }
    public static LocalDate toLocalDate(String date, String format, LocalDate nullValue) {
        if (date == null){
            return nullValue;
        }
        if (format == null){
            format = "dd/MM/yyyy";
        }
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
            return LocalDate.parse(date, formatter);
        } catch (Exception e) {
            return nullValue;
        }
    }

    //LocalDateTime
    public static LocalDateTime toLocalDateTime(java.util.Date date) {
        return toLocalDateTime(date, null);
    }
    public static LocalDateTime toLocalDateTime(java.util.Date date, LocalDateTime nullValue) {
        if (date == null){
            return nullValue;
        }
        try{
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        } catch (Exception e) {
            return nullValue;
        }
    }
    public static LocalDateTime toLocalDateTime(String dateTime, String format) {
        return toLocalDateTime(dateTime, format, null);
    }
    public static LocalDateTime toLocalDateTime(String dateTime, String format, LocalDateTime nullValue) {
        if (dateTime == null){
            return nullValue;
        }
        if (format == null){
            format = "dd/MM/yyyy HH:mm:ss";
        }
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
            return LocalDateTime.parse(dateTime, formatter);
        } catch (Exception e) {
            return nullValue;
        }
    }

    //String
    public static String toString(Object text) {
        if (text == null){
            return "";
        }
        try{
            return text.toString();
        }catch(Exception e){
            return "";
        }
    }
    public static String toString(char value) {
        try{
            StringBuilder s = new StringBuilder();
            s.append(value);
            return s.toString();
        }catch(Exception e){
            return "";
        }
    }
    public static String toString(boolean value) {
        try{
            StringBuilder s = new StringBuilder();
            s.append(value);
            return s.toString();
        }catch(Exception e){
            return "";
        }
    }
    public static String toString(double value) {
        try{
            StringBuilder s = new StringBuilder();
            s.append(value);
            return s.toString();
        }catch(Exception e){
            return "";
        }
    }
    public static String toString(float value) {
        try{
            StringBuilder s = new StringBuilder();
            s.append(value);
            return s.toString();
        }catch(Exception e){
            return "";
        }
    }
    public static String toString(long value) {
        try{
            StringBuilder s = new StringBuilder();
            s.append(value);
            return s.toString();
        }catch(Exception e){
            return "";
        }
    }
    public static String toString(int value) {
        try{
            StringBuilder s = new StringBuilder();
            s.append(value);
            return s.toString();
        }catch(Exception e){
            return "";
        }
    }
    public static String toString(short value) {
        try{
            StringBuilder s = new StringBuilder();
            s.append(value);
            return s.toString();
        }catch(Exception e){
            return "";
        }
    }
    public static String toString(byte value) {
        try{
            StringBuilder s = new StringBuilder();
            s.append(value);
            return s.toString();
        }catch(Exception e){
            return "";
        }
    }
    public static String toString(java.util.Date date, String format) {
        if (date == null){
            return "";
        }
        if (format == null){
            format = "dd/MM/yyyy";
        }
        try{
            SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
            formatter.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));
            return formatter.format(date);
        } catch (Exception e) {
            return "";
        }
    }
    public static String toString(LocalDate date, String format) {
        if (date == null){
            return "";
        }
        if (format == null){
            format = "dd/MM/yyyy";
        }
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
            return date.format(formatter);
        } catch (Exception e) {
            return "";
        }
    }
    public static String toString(LocalDateTime dateTime, String format) {
        if (dateTime == null){
            return "";
        }
        if (format == null){
            format = "dd/MM/yyyy HH:mm:ss";
        }
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
            return dateTime.format(formatter);
        } catch (Exception e) {
            return "";
        }
    }
}
