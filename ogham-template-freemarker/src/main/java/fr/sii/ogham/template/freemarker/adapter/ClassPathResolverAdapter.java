package fr.sii.ogham.template.freemarker.adapter;

import fr.sii.ogham.core.resource.resolver.ClassPathResolver;
import fr.sii.ogham.core.resource.resolver.DelegateResourceResolver;
import fr.sii.ogham.core.resource.resolver.ResourceResolver;
import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;

/**
 * Adapter that converts general {@link ClassPathResolver} into FreeMarker
 * specific {@link ClassTemplateLoader}.
 * 
 * @author Cyril Dejonghe
 *
 */
public class ClassPathResolverAdapter extends AbstractFreeMarkerTemplateLoaderOptionsAdapter implements TemplateLoaderAdapter {
	@Override
	public boolean supports(ResourceResolver resolver) {
		ResourceResolver actualResolver = resolver instanceof DelegateResourceResolver ? ((DelegateResourceResolver) resolver).getActualResourceResolver() : resolver;
		return actualResolver instanceof ClassPathResolver;
	}

	@Override
	public TemplateLoader adapt(ResourceResolver resolver) {
		return new ClassTemplateLoader(resolver.getClass(), "");
	}

}
