/**
 * Copyright (c) 2010-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.gardena.internal.model.command;

/**
 * Command to resume the mower scheduler.
 *
 * @author Gerhard Riegler - Initial contribution
 */

public class MowerStartResumeScheduleCommand extends Command {
    private static final String COMMAND = "start_resume_schedule";

    public MowerStartResumeScheduleCommand() {
        super(COMMAND);
    }
}
