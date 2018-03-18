package com.bazaar.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
public class MfDate implements Serializable {


	  public static final MfDate PAST = new MfDate(new GregorianCalendar(0, 1, 1));
	  public static final MfDate FUTURE = new MfDate(new GregorianCalendar(10000, 1, 1));
	private static final long serialVersionUID = 1L;
 	  private static MfDate myToday;
	  @Id
	  @GeneratedValue
	  private long mid;
	  private SimpleDateFormat myFormatter = (SimpleDateFormat) DateFormat.getDateInstance();
	  private GregorianCalendar myBase;
	  public MfDate() {
	    this(new GregorianCalendar());
	  }
	  public MfDate(int year, int month, int day) {

	    initialize(new GregorianCalendar(year-1900, month - 1, day));
	  }
	  public MfDate(Date arg) {
	    GregorianCalendar gc = new GregorianCalendar();
	    gc.setTime(arg);
	    initialize(gc);
	  }
	  public MfDate(GregorianCalendar arg) {
	    initialize(arg);
	  }

	  public static MfDate past() {
	    GregorianCalendar greg = new GregorianCalendar(0, 1, 1);
	    return new MfDate(greg);
	  }

	  public static void setToday(int year, int month, int day) {
	    MfDate.setToday(new MfDate(year, month, day));
	  }

	  public static void setToday(MfDate arg) {
	    myToday = arg;
	  }

	  public static MfDate today() {
	    return ((myToday == null) ? new MfDate() : myToday);
	  }

	  private void initialize(GregorianCalendar arg) {

	    myBase = trimToDays(arg);
	  }

	  private GregorianCalendar trimToDays(GregorianCalendar arg) {
	    arg.set(Calendar.HOUR_OF_DAY, 0);
	    arg.set(Calendar.MINUTE, 0);
	    arg.set(Calendar.SECOND, 0);
	    arg.set(Calendar.MILLISECOND, 0);
	    return arg;
	  }

	  public MfDate addDays(int arg) {
	    return new MfDate(new GregorianCalendar(getYear(), getMonth(), getDayOfMonth() + arg));
	  }

	  public MfDate minusDays(int arg) {
	    return addDays(-arg);
	  }

	  public boolean after(MfDate arg) {
	    return getTime().after(arg.getTime());
	  }

	  public boolean before(MfDate arg) {
	    return getTime().before(arg.getTime());
	  }

	  public int compareTo(Object arg) {
	    MfDate other = (MfDate) arg;
	    return getTime().compareTo(other.getTime());
	  }

	  @Override
	  public boolean equals(Object arg) {
	    if (!((arg instanceof MfDate))) {
	      return false;
	    }
	    MfDate other = (MfDate) arg;
	    return (myBase.equals(other.myBase));
	  }

	  public Date getTime() {
	    return myBase.getTime();
	  }

	  public String formattedString() {
	    return myFormatter.format(getTime());
	  }

	  public GregorianCalendar getCalendar() {
	    return myBase;
	  }

	  public int getDayOfMonth() {
	    return myBase.get(Calendar.DAY_OF_MONTH);
	  }

	  public String getMediumString() {
	    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	    return df.format(getTime());
	  }

	  public int getMonth() {
	    return myBase.get(Calendar.MONTH);
	  }

	  public String getSqlString() {
	    myFormatter.applyPattern("#M/d/yyyy#");
	    return myFormatter.format(getTime());
	  }

	  public int getYear() {
	    return myBase.get(Calendar.YEAR);
	  }

	  @Override
	  public int hashCode() {
	    return myBase.hashCode();
	  }

	  public String rawString() {
	    return myBase.getTime().toString();
	  }

	  //@Override
	 public String toString() {
	    return formattedString();
	  }

	  public java.sql.Date toSqlDate(){
	        return new java.sql.Date(myBase.get(Calendar.YEAR), myBase.get(Calendar.MONTH), myBase.get(Calendar.DAY_OF_MONTH));
	  }

	public long getMid() {
		return mid;
	}

	public void setMid(int id) {
		this.mid = id;
	}
}
