/*
 * The MIT License
 *
 * Copyright (c) 2017 Oleg Nenashev.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.remoting;

import hudson.Extension;
import hudson.model.Node;
import hudson.model.Slave;
import hudson.slaves.ComputerLauncher;
import hudson.slaves.JNLPLauncher;
import jenkins.slaves.DefaultComputerLauncherProvider;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

/**
 * Makes {@link JNLPLauncher} a default launcher for {@link Slave} instances.
 * It retains the default behavior of old Jenkins versions if the detached plugin is installed.
 * @author Oleg Nenashev
 */
@Extension
@Restricted(NoExternalUse.class)
public class JNLPComputerLauncherProvider extends DefaultComputerLauncherProvider {

    @Override
    public ComputerLauncher getDefaultLauncher(Class<? extends Node> nodeClass) {
        if (Slave.class.isAssignableFrom(nodeClass)) {
            return new JNLPLauncher();
        }
        return null;
    }   
}
