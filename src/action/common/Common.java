package common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Element;

import au.com.bytecode.opencsv.CSVReader;
import config.XmlHelper;

public class Common {

	public static synchronized Common getCommon() {
		if (instance == null) {
			instance = new Common();
		}

		return instance;
	}

	/**
	 * Return a random unique string
	 * 
	 * @return unique string
	 */
	public String getUniqueName() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * Return a random unique string
	 * 
	 * @return unique string
	 */
	public String getUniqueName(int index) {
		return UUID.randomUUID().toString().replace("-", "").substring(0, index);
	}
	
	/**
	 * Return a random unique number
	 * 
	 * @return unique number
	 */
	public String getUniqueNumber() {
		Random rand = new Random();
		int number = rand.nextInt(1000000) + 1;
		String numberString = Integer.toString(number);
		return numberString;
	}
	
	/**
	 * Get date follow download template
	 * 
	 * @return unique number
	 */
	public String getDateDownloadFormat() {
		int day = getCurrentDay();
		int month = getCurrentMonth();
		int year = getCurrentYear();
		if(day<10){
			if(month<10) return "0"+day+"_0"+month+"_"+year;
			else return "0"+day+"_"+month+"_"+year;
		}else{
			if(month<10) return day+"_0"+month+"_"+year;
			else return day+"_"+month+"_"+year;
		}
	}

	/**
	 * get data from data.xml file
	 * 
	 * @param testModuleName
	 * @param tagName
	 * @return result: data set value
	 */
	public String getDataSet(String testModuleName, String tagName) {
		String result = "";
		try {
			XmlHelper xml = new XmlHelper();
			xml.parseResource(Constant.PathConfig.DATA_TEST_XML);
			for (Element element : xml.getElements("/DataTest/TestModules/TestModule")) {
				if (element.getAttribute("name").equals(testModuleName)) {
					result = element.getElementsByTagName(tagName).item(0).getTextContent();
					break;
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return result;
	}

	/**
	 * convert 12 hours to 24 hours format
	 * 
	 * @param dateStr
	 * @return
	 */
	public String convertHoursFormat(String dateStr) {

		String formattedDate = null;
		DateFormat readFormat = new SimpleDateFormat("hh:mm:ss aa");
		DateFormat writeFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		try {
			date = readFormat.parse(dateStr);
			formattedDate = writeFormat.format(date);
			return formattedDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get day of week
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return day of week
	 * @throws ParseException
	 */
	public String getDayOfWeek(int day, int month, int year) {
		try {
			String strDate = day + "/" + month + "/" + year;
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date dt = format.parse(strDate);
			DateFormat dateFormat = new SimpleDateFormat("EEEE");
			return dateFormat.format(dt);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}

	/**
	 * Comverton month
	 * 
	 * @param month
	 * @return month in string
	 */
	public String convertMonth(int month) {
		String m = null;
		switch (month) {
		case 1:
			m = "January";
			break;
		case 2:
			m = "February";
			break;
		case 3:
			m = "March";
			break;
		case 4:
			m = "April";
			break;
		case 5:
			m = "May";
			break;
		case 6:
			m = "June";
			break;
		case 7:
			m = "July";
			break;
		case 8:
			m = "August";
			break;
		case 9:
			m = "September";
			break;
		case 10:
			m = "October";
			break;
		case 11:
			m = "November";
			break;
		case 12:
			m = "December";
			break;
		default:
			break;

		}
		return m;
	}

	/**
	 * convert to month
	 * 
	 * @param monthName
	 * @return month
	 */
	public int convertMonth(String monthName) {
		int m = 0;
		if (monthName.toUpperCase().contains("JAN"))
			m = 1;
		else if (monthName.toUpperCase().contains("FEB"))
			m = 2;
		else if (monthName.toUpperCase().contains("MAR"))
			m = 3;
		else if (monthName.toUpperCase().contains("APR"))
			m = 4;
		else if (monthName.toUpperCase().contains("MAY"))
			m = 5;
		else if (monthName.toUpperCase().contains("JUN"))
			m = 6;
		else if (monthName.toUpperCase().contains("JUL"))
			m = 7;
		else if (monthName.toUpperCase().contains("AUG"))
			m = 8;
		else if (monthName.toUpperCase().contains("SEP"))
			m = 9;
		else if (monthName.toUpperCase().contains("OCT"))
			m = 10;
		else if (monthName.toUpperCase().contains("NOV"))
			m = 11;
		else if (monthName.toUpperCase().contains("DEC"))
			m = 12;
		return m;
	}

	/**
	 * get current day with plus day
	 * 
	 * @param days
	 * @return day with plus day
	 */
	public int getCurrentDayWithPlusDays(int days) {
		DateTime dt = DateTime.now();
		return dt.plusDays(days).getDayOfMonth();
	}

	/**
	 * get month when current day plus days
	 * 
	 * @param days
	 * @return month with plus day
	 */
	public int getCurrentMonthWithPlusDays(int days) {
		DateTime dt = DateTime.now();
		return dt.plusDays(days).getMonthOfYear();
	}

	/**
	 * get year when current day plus days
	 * 
	 * @param days
	 * @return year with plus day
	 */
	public int getCurrentYearWithPlusDays(int days) {
		DateTime dt = DateTime.now();
		return dt.plusDays(days).getYear();
	}

	/**
	 * get current day
	 * 
	 * @return current day
	 */
	public int getCurrentDay() {
		DateTime now = DateTime.now();
		return now.getDayOfMonth();
	}

	/**
	 * get current month
	 * 
	 * @return current month
	 */
	public int getCurrentMonth() {
		DateTime now = DateTime.now();
		return now.getMonthOfYear();
	}

	/**
	 * get current year
	 * 
	 * @return current year
	 */
	public int getCurrentYear() {
		DateTime now = DateTime.now();
		return now.getYear();
	}

	/**
	 * get current hour
	 * 
	 * @return current hour
	 */
	public int getCurrentHours() {
		DateTime now = DateTime.now();
		return now.getHourOfDay();
	}

	/**
	 * get current minute
	 * 
	 * @return current minute
	 */
	public int getCurrentMinutes() {
		DateTime now = DateTime.now();
		return now.getMinuteOfHour();
	}

	/**
	 * get logout link
	 */
	public String getLogoutLink() {
		return logOutLink;
	}

	/**
	 * set logout link
	 * 
	 * @param url
	 */
	public void setLogoutLink(String url) {
		this.logOutLink = url;
	}

	/**
	 * Comverton month
	 * 
	 * @param month
	 * @return short name month
	 */
	public String convertShortMonth(int month) {
		String m = null;
		switch (month) {
		case 1:
			m = "Jan";
			break;
		case 2:
			m = "Feb";
			break;
		case 3:
			m = "Mar";
			break;
		case 4:
			m = "Apr";
			break;
		case 5:
			m = "May";
			break;
		case 6:
			m = "Jun";
			break;
		case 7:
			m = "Jul";
			break;
		case 8:
			m = "Aug";
			break;
		case 9:
			m = "Sep";
			break;
		case 10:
			m = "Oct";
			break;
		case 11:
			m = "Nov";
			break;
		case 12:
			m = "Dec";
			break;
		default:
			break;

		}
		return m;
	}

	/**
	 * Get current time of America
	 * 
	 * @return time such as 2:20 am
	 */
	public String getCurrentTimeAmerica() {
		DateTimeZone dateTimeZone = DateTimeZone.forID("America/Los_Angeles");
		DateTime dt = new DateTime(dateTimeZone);
		return dt.toString("hh:mm a").toLowerCase();
	}

/**
 * capture and convert screenshot to URI data
 * @param filename
 * @param filepath
 * @return string htmlScript
 */
	public String captureAndConvertImageToURI(String filename, String filepath){
		WebDriver driver = DriverManager.getDriver();
		String path = "";
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		String randomPopUpId = Common.getCommon().getUniqueName();
		String randomButtonId = randomPopUpId +"button";
		try {
			// Taking the screen using TakesScreenshot Class
			File objScreenCaptureFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String currentDir = new File(".").getAbsolutePath().replace(".", "");
			// Storing the image in the local system.
			FileUtils.copyFile(objScreenCaptureFile, new File(currentDir + filepath + "\\" + filename + ".png"));
			path = currentDir + filepath + "\\" + filename + ".png";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage img;
		File image = new File(path);
		try {
			img = ImageIO.read(image);
			ByteArrayOutputStream convert = new ByteArrayOutputStream();
			ImageIO.write(img, "png", convert);
			String data = DatatypeConverter.printBase64Binary(convert.toByteArray());
			String imageString = "data:image/png;base64," + data;
			String htmlScript = "<script>$(document).ready(function(){$( \"#"+randomPopUpId+"\" ).dialog({ autoOpen: false });$( \"#"+randomPopUpId+"\" ).dialog({width:1000},{height:700});$( \"#"+randomButtonId+"\" ).click(function() {$( \"#"+randomPopUpId+"\" ).dialog( \"open\" );});});</script></br><img id=\"" + randomButtonId + "\" src=\"" + imageString + "\" style=\"border: 4px solid #f6f7fa;width: 150px;cursor: zoom-in;display: block;margin-top: 15px;\"/></br><div style=\"width: 50%; margin: 0 auto;\" id=\""+randomPopUpId+"\" > <a href=\"#"+randomPopUpId+"\"  class=\"ui-btn ui-corner-all ui-shadow ui-btn-a ui-icon-delete ui-btn-icon-notext ui-btn-right\"></a><img style=\"width:800px;height:600;\"  src=\"" + imageString + "\"/></div>";
			image.delete(); // delete image after converted
			return htmlScript;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Press ENTER key by Robot class
	 */
	public void pressEnterByRobot() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);//sleep 2s to wait process finish
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * check file is existed
	 * @param file
	 * @return true/false
	 */
	public boolean isFileExists(String file) {
		try {
			String pathFolderDownload = getPathContainDownload();
			File files = new File(pathFolderDownload + file);
			boolean exists = files.exists();
			return exists;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}

	/**
	 * get path contain download file
	 * @return path
	 */
	public String getPathContainDownload() {
		String path = "";
		String currentUser = System.getProperty("user.name");
		path = String.format(Constant.PathConfig.FOLDER_DOWNLOAD_ON_WIN, currentUser);
		return path;
	}
	
	/**
	 * Delete a file from local PC
	 * @param file
	 */
	public void deleteFile(String file) {
		try {
			if (isFileExists(file)) {
				String pathFolderDownload = getPathContainDownload();
				File files = new File(pathFolderDownload + file);
				files.delete();
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	/**
	 * Delete a file from local PC
	 * @param file
	 */
	public void waitForFileExist(String file, int times) {
		try {
			boolean isDownloaded = isFileExists(file);
			int i = 0;
			while (isDownloaded == false && i <= times) {
				Thread.sleep(1000);
				i++;
				isDownloaded = isFileExists(file);
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * get full path of file
	 * @param fileName
	 * @return file path
	 */
	public String getPathFile(String fileName)
	{
		File file = new File(fileName);
		return file.getAbsolutePath();
	}
	
	/**
	 * generate file
	 * @param fileName
	 */
	public void generateFile(String fileName){
		try {
			File statText = new File("..\\Mailosaur\\test-output\\"+fileName);
			FileOutputStream is = new FileOutputStream(statText);
			OutputStreamWriter osw = new OutputStreamWriter(is);    
			Writer w = new BufferedWriter(osw);
			w.write("Mailosaur Automation Testing content");
			w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file txt");
        }
	}
	
	/**
	 * Delete a file from local PC
	 * @param file
	 */
	public void deleteGeneratedFile(String file) {
		try {
			if (isGeneratedFileExists(file)) {
				String pathFile = "..\\Mailosaur\\test-output\\"+file;
				File files = new File(pathFile);
				files.delete();
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	/**
	 * check file is existed
	 * @param file
	 * @return true/false
	 */
	public boolean isGeneratedFileExists(String file) {
		try {
			String pathFile = "..\\Mailosaur\\test-output\\"+file;
			File files = new File(pathFile);
			boolean exists = files.exists();
			return exists;
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Get a random int
	 * @param max
	 * @return
	 */
	public int getRandomInt(int max){
		Random rd = new Random();
		return rd.nextInt(max);
	}
	
	public int getNumberOfUrl(String fileName){
		 // This will load csv file 
		int numberOfUrl = 0;
		try{
		 CSVReader reader = new CSVReader(new FileReader(getPathFile("src/resource/file/"+fileName)));
		 
		 // this will load content into list
		  List<String[]> li=reader.readAll();
		  System.out.println("Total rows which we have is "+li.size());
		  reader.close();
		  numberOfUrl = li.size() -1;
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return numberOfUrl;
		}

	
	public String[] getUrlListByReadCSVFile(String fileName){
		 // This will load csv file 
		String[] urlList = new String[1000];
		try{
		 CSVReader reader = new CSVReader(new FileReader(getPathFile("src/resource/file/"+fileName)));
		 
		 // this will load content into list
		  List<String[]> li=reader.readAll();
//		  System.out.println("Total rows which we have is "+li.size());
		           
		  reader.close();
		  
		// create Iterator reference
		  Iterator<String[]>i1= li.iterator();
		  i1.next();
		 int i=0;
		 // Iterate all values 
		 while(i1.hasNext()){
		     
		 String[] str=i1.next();
//		 System.out.println("Link: "+str[0]+"/"+str[1]);
		 urlList[i] = "/"+str[0]+"/"+str[1];
		 i++;
		 } 
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return urlList;
		}

	
	public static String en = "";
	private String logOutLink = "";
	private static Common instance = null;
}