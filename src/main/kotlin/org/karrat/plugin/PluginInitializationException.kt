/*
 * Copyright © Karrat - 2022.
 */

package org.karrat.plugin

public class PluginInitializationException(
    message: String? = null,
    cause: Throwable? = null
) : PluginException(message, cause)