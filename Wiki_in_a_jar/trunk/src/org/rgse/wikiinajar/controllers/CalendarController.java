package org.rgse.wikiinajar.controllers;

import java.io.IOException;
import java.util.Calendar;

import net.sf.wikiinajar.xrays.ControllerResponse;
import net.sf.wikiinajar.xrays.Request;

import org.rgse.wikiinajar.helpers.DateUtils;
import org.rgse.wikiinajar.models.Month;
import org.rgse.wikiinajar.views.calendar.MonthView;

public class CalendarController {

	public ControllerResponse defaultAction(Request request) throws IOException {
		switch (DateUtils.getCurrentMonth()) {
		case Calendar.JANUARY:
			return request.forward(januaryAction(request), "month");
		case Calendar.FEBRUARY:
			return request.forward(februaryAction(request), "month");
		case Calendar.MARCH:
			return request.forward(marchAction(request), "month");
		case Calendar.APRIL:
			return request.forward(aprilAction(request), "month");
		case Calendar.MAY:
			return request.forward(mayAction(request), "month");
		case Calendar.JUNE:
			return request.forward(juneAction(request), "month");
		case Calendar.JULY:
			return request.forward(julyAction(request), "month");
		case Calendar.AUGUST:
			return request.forward(augustAction(request), "month");
		case Calendar.SEPTEMBER:
			return request.forward(septemberAction(request), "month");
		case Calendar.OCTOBER:
			return request.forward(octoberAction(request), "month");
		case Calendar.NOVEMBER:
			return request.forward(novemberAction(request), "month");
		case Calendar.DECEMBER:
			return request.forward(decemberAction(request), "month");
		}
		return null;
	}

	public ControllerResponse januaryAction(Request request) throws IOException {
		return monthHelper(request, Calendar.JANUARY);
	}

	public ControllerResponse februaryAction(Request request)
			throws IOException {
		return monthHelper(request, Calendar.FEBRUARY);
	}

	public ControllerResponse marchAction(Request request) throws IOException {
		return monthHelper(request, Calendar.MARCH);
	}

	public ControllerResponse aprilAction(Request request) throws IOException {
		return monthHelper(request, Calendar.APRIL);
	}

	public ControllerResponse mayAction(Request request) throws IOException {
		return monthHelper(request, Calendar.MAY);
	}

	public ControllerResponse juneAction(Request request) throws IOException {
		return monthHelper(request, Calendar.JUNE);
	}

	public ControllerResponse julyAction(Request request) throws IOException {
		return monthHelper(request, Calendar.JULY);
	}

	public ControllerResponse augustAction(Request request) throws IOException {
		return monthHelper(request, Calendar.AUGUST);
	}

	public ControllerResponse septemberAction(Request request)
			throws IOException {
		return monthHelper(request, Calendar.SEPTEMBER);
	}

	public ControllerResponse octoberAction(Request request) throws IOException {
		return monthHelper(request, Calendar.OCTOBER);
	}

	public ControllerResponse novemberAction(Request request)
			throws IOException {
		return monthHelper(request, Calendar.NOVEMBER);
	}

	public ControllerResponse decemberAction(Request request)
			throws IOException {
		return monthHelper(request, Calendar.DECEMBER);
	}

	private ControllerResponse monthHelper(Request request, int month)
			throws IOException {
		int year = determineYear(request.getPath().getId());
		Month m = new Month(month, year);
		m.loadEvents();
		MonthView view = new MonthView(m);
		return request.xmlResponse(view.toXml(), "month");
	}

	/**
	 * Converts given string into a number representing a year. If that fails,
	 * returns current year.
	 * 
	 * @param year
	 *            The year as string or <code>null</code> for current year.
	 * @return
	 */
	private int determineYear(String year) {
		int y = Calendar.getInstance().get(Calendar.YEAR);
		try {
			y = Integer.parseInt(year);
		} catch (NumberFormatException e) {
			// just use current
		}
		return y;
	}

}
