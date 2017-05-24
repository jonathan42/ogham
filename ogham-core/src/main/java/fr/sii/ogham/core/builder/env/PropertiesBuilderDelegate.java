package fr.sii.ogham.core.builder.env;

import java.util.Properties;

import fr.sii.ogham.core.builder.AbstractParent;
import fr.sii.ogham.core.exception.builder.BuildException;

/**
 * Implementation that just delegates all operations to another builder.
 * 
 * <p>
 * This is useful when a {@link PropertiesBuilder} is used for a particular
 * parent and it must be inherited. As the parent types are not the same, you
 * can't directly use the same reference. So this implementation wraps the
 * original reference but as it is a new instance, it can have a different
 * parent builder.
 * </p>
 * 
 * @author Aurélien Baudet
 *
 * @param <P>
 *            the type of the parent builder (when calling {@link #and()}
 *            method)
 */
public class PropertiesBuilderDelegate<P> extends AbstractParent<P> implements PropertiesBuilder<P> {
	private PropertiesBuilder<?> delegate;
	
	/**
	 * Wraps the delegate builder. The delegated builder parent is not used.
	 * This instance uses the provided parent instead for chaining.
	 * 
	 * @param parent
	 *            the new parent used for chaining
	 * @param delegate
	 *            the instance that will really be updated
	 */
	public PropertiesBuilderDelegate(P parent, PropertiesBuilder<?> delegate) {
		super(parent);
		this.delegate = delegate;
	}

	@Override
	public PropertiesBuilder<P> set(String key, String value) {
		delegate.set(key, value);
		return this;
	}

	@Override
	public Properties build() throws BuildException {
		return delegate.build();
	}

}
