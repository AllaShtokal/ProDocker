package alla.shtokal.hibernatesearch;

import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurationContext;
import org.hibernate.search.backend.elasticsearch.analysis.ElasticsearchAnalysisConfigurer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("hibernate")
@Component("AnalysisConfigurer")
public class AnalysisConfigurer implements ElasticsearchAnalysisConfigurer {
    @Override
    public void configure(ElasticsearchAnalysisConfigurationContext context) {
        context.analyzer("cleaned_text").custom()
                .tokenizer("whitespase").charFilters("html_strip")
                .tokenFilters("asciifolding", "lowercase", "stop", "porter_stem");
        context.normalizer("cleaned_keyword").custom()
                .tokenFilters("asciifolding", "lowercase");
    }

}
