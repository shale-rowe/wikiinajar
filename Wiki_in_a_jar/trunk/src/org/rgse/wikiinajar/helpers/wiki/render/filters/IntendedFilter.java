/*
 * Wiki in a jar
 * 
 * Copyright (C) 2007 rico_g AT users DOT sourceforge DOT net
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License s published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 * 
 */

package org.rgse.wikiinajar.helpers.wiki.render.filters;

/**
 * @author rico_g AT users DOT sourceforge DOT net
 * 
 */
public class IntendedFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.rgse.render.filter.Filter#filter(java.lang.String)
	 */
	public String filter(String text) {
		StringBuffer buffer = new StringBuffer();
		String[] lines = text.split("\n");

		boolean intended = false;
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			if (line.startsWith(" ") && line.trim().length() > 0) {
				if (!intended) {
					buffer.append("<pre id='intended'>\n");
					intended = true;
				}

			} else if (intended) {
				buffer.append("</pre>\n");
				intended = false;
			}
			buffer.append(line);
			buffer.append("\n");

		}
		if (intended) {
			buffer.append("</pre>\n");
		}
		return buffer.toString();
	}

}
