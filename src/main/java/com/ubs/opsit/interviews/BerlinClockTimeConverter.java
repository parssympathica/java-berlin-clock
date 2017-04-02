package com.ubs.opsit.interviews;

public class BerlinClockTimeConverter implements TimeConverter{

	private static final String MATCHING_FORMAT = "(24:0{1,2}:0{1,2})|(([0-2])?[0-3]\\:([0-5])?[0-9]\\:([0-5])?[0-9])";
	private static final String O = "O";
	private static final String R = "R";
	private static final String Y = "Y";
	private static final String SEPARATOR = "\\:";

	@Override
	public String convertTime(String aTime) {
		assert aTime.matches(MATCHING_FORMAT) : "Provided time format is not acceptable.";
		String[] split = aTime.split(SEPARATOR);
		int hours = Integer.parseInt(split[0]);
		int minutes = Integer.parseInt(split[1]);
		int seconds = Integer.parseInt(split[2]);
		Object[] lights = {
							seconds%2 == 0 ? Y : O,
							
							hours/5 >=1 ? R : O,
							hours/5 >=2 ? R : O,		
							hours/5 >=3 ? R : O,
							hours/5 >=4 ? R : O,
							
									
							hours%5 >= 1 ? R : O,
							hours%5 >= 2 ? R : O,
							hours%5 >= 3 ? R : O,
							hours%5 >= 4 ? R : O,
									
							minutes/5 >=1 ? Y : O,
							minutes/5 >=2 ? Y : O,
							minutes/5 >=3 ? R : O,
							minutes/5 >=4 ? Y : O,
							minutes/5 >=5 ? Y : O,
							minutes/5 >=6 ? R : O,
							minutes/5 >=7 ? Y : O,
							minutes/5 >=8 ? Y : O,
							minutes/5 >=9 ? R : O,
							minutes/5 >=10 ? Y : O,
							minutes/5 >=11 ? Y : O,
									
							minutes%5 >= 1 ? Y : O,
							minutes%5 >= 2 ? Y : O,
							minutes%5 >= 3 ? Y : O,
							minutes%5 >= 4 ? Y : O
				};
		return String.format("%s%n%s%s%s%s%n%s%s%s%s%n%s%s%s%s%s%s%s%s%s%s%s%n%s%s%s%s", lights);
	}

}

