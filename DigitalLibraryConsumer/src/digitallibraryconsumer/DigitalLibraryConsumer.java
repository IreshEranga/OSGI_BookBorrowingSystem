package digitallibraryconsumer;

import digitallibraryproducer.DigitalLibraryService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class DigitalLibraryConsumer implements BundleActivator {
    private ServiceReference<DigitalLibraryService> serviceReference;

    @Override
    public void start(BundleContext context) throws Exception {
        serviceReference = context.getServiceReference(DigitalLibraryService.class);
        if (serviceReference != null) {
            DigitalLibraryService service = context.getService(serviceReference);
            System.out.println(service.downloadEBook("OSGi for Beginners"));
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        context.ungetService(serviceReference);
        System.out.println("Digital Library Consumer Stopped");
    }
}
