package com.yun.log

import org.slf4j.{Logger, LoggerFactory}

//import org.slf4j.{Logger, LoggerFactory}

trait LoggerTrait {
  @transient private var log_ : Logger = null

  protected def log: Logger = {
    if (log_ == null) {
      //      log_ = LoggerFactory.getLogger(logName)
//      log_ =Logger.getLogger(logName)
      log_ =LoggerFactory.getLogger(logName)
    }
    log_
  }

  // Method to get the logger name for this object
  protected def logName: String = {
    // Ignore trailing $'s in the class names for Scala objects
    this.getClass.getName.stripSuffix("$")
  }

  protected def logInfo(msg: => String) {
    if (log.isInfoEnabled) {
      log.info(msg)
    }
  }

  protected def logDebug(msg: => String) {
    if (log.isDebugEnabled) {
      log.debug(msg)
    }
  }

  protected def logTrace(msg: => String) {
    if (log.isTraceEnabled)
      log.trace(msg)
  }

  protected def logWarning(msg: => String) {
    if (log.isWarnEnabled) {
      log.warn(msg)
    }
  }

  protected def logError(msg: => String) {
    if (log.isErrorEnabled) {
      log.error(msg)
    }
  }

  protected def logInfo(msg: => String, throwable: Throwable) {
    if (log.isInfoEnabled) {
      log.info(msg, throwable)
    }
  }

  protected def logDebug(msg: => String, throwable: Throwable) {
    if (log.isDebugEnabled) {
      log.debug(msg, throwable)
    }
  }

  protected def logTrace(msg: => String, throwable: Throwable) {
    if (log.isTraceEnabled) {
      log.trace(msg, throwable)
    }
  }

  protected def logWarning(msg: => String, throwable: Throwable) {
    if (log.isWarnEnabled) {
      log.warn(msg, throwable)
    }
  }

  protected def logError(msg: => String, throwable: Throwable) {
    if (log.isErrorEnabled) {
      log.error(msg, throwable)
    }
  }
}

