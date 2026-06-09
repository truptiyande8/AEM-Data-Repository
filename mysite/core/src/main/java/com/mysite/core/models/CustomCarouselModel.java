package com.mysite.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(
        adaptables = Resource.class,
        adapters = CustomCarouselModel.class,
        resourceType = "mysite/components/custom-carousel",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson",extensions = "json")
public class CustomCarouselModel {
    private static final Logger LOG =
            LoggerFactory.getLogger(CustomCarouselModel.class);

    @ValueMapValue
    private String heading;

    @ChildResource(name = "slides")
    private Resource slides;

    private List<CarouselItem> carouselItems;

    @PostConstruct
    protected void init() {

        carouselItems = new ArrayList<>();

        if (slides != null) {

            for (Resource item : slides.getChildren()) {

                CarouselItem carouselItem =
                        item.adaptTo(CarouselItem.class);
                LOG.info("Carousel Item List" ,carouselItem);
                if (carouselItem != null) {
                    carouselItems.add(carouselItem);
                }
            }
        }
    }

    public String getHeading() {
        return heading;
    }

    public List<CarouselItem> getCarouselItems() {
        return carouselItems;
    }
}
