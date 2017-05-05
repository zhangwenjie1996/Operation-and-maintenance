package ig.zeus;

import ig.archer.infrastructure.log.ILogger;

/**
 * 使用 log4j進行日志记录。
 * 
 * @author reize
 * @version 0.0.1
 * @since 2016年9月18日 下午2:13:43
 */
public class Logger implements ILogger {
	private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);

	@Override
	public boolean isTraceEnabled() {
		return this.logger.isTraceEnabled();
	}

	@Override
	public void trace(Throwable t) {
		this.logger.trace(t);
	}

	@Override
	public void trace(String format, Object... args) {
		String message = format;
		if (args != null)
			message = String.format(format, args);
		this.logger.trace(message);
	}

	@Override
	public void trace(Throwable t, String format, Object... args) {
		String message = format;
		if (args != null)
			message = String.format(format, args);
		this.logger.trace(message, t);
	}

	@Override
	public boolean isDebugEnabled() {
		return this.logger.isDebugEnabled();
	}

	@Override
	public void debug(Throwable t) {
		this.logger.debug(t);
	}

	@Override
	public void debug(String format, Object... args) {
		String message = format;
		if (args != null)
			message = String.format(format, args);
		this.logger.debug(message);
	}

	@Override
	public void debug(Throwable t, String format, Object... args) {
		String message = format;
		if (args != null)
			message = String.format(format, args);
		this.logger.debug(message, t);
	}

	@Override
	public boolean isInfoEnabled() {
		return this.logger.isInfoEnabled();
	}

	@Override
	public void info(Throwable t) {
		this.logger.info(t);
	}

	@Override
	public void info(String format, Object... args) {
		String message = format;
		if (args != null)
			message = String.format(format, args);
		this.logger.info(message);
	}

	@Override
	public void info(Throwable t, String format, Object... args) {
		String message = format;
		if (args != null)
			message = String.format(format, args);
		this.logger.info(message, t);
	}

	@Override
	public boolean isWarnEnabled() {
		return true;
	}

	@Override
	public void warn(Throwable t) {
		this.logger.warn(t);
	}

	@Override
	public void warn(String format, Object... args) {
		String message = format;
		if (args != null)
			message = String.format(format, args);
		this.logger.warn(message);
	}

	@Override
	public void warn(Throwable t, String format, Object... args) {
		String message = format;
		if (args != null)
			message = String.format(format, args);
		this.logger.warn(message, t);
	}

	@Override
	public boolean isErrorEnabled() {
		return true;
	}

	@Override
	public void error(Throwable t) {
		this.logger.error(t);
	}

	@Override
	public void error(String format, Object... args) {
		String message = format;
		if (args != null)
			message = String.format(format, args);
		this.logger.error(message);
	}

	@Override
	public void error(Throwable t, String format, Object... args) {
		String message = format;
		if (args != null)
			message = String.format(format, args);
		this.logger.error(message, t);
	}

	@Override
	public String getName() {
		return this.logger.getName();
	}
}
