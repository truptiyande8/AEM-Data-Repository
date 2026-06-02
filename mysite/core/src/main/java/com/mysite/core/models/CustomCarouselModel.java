package com.mysite.core.models;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CustomCarouselModel {

    @ValueMapValue
    private String heading;

    @ValueMapValue
    private boolean autoplay;

    @ValueMapValue
    private String interval;

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

                if (carouselItem != null) {
                    carouselItems.add(carouselItem);
                }
            }
        }
    }

    public String getHeading() {
        return heading;
    }

    public boolean isAutoplay() {
        return autoplay;
    }

    public String getInterval() {
        return interval;
    }

    public List<CarouselItem> getCarouselItems() {
        return carouselItems;
    }
}
