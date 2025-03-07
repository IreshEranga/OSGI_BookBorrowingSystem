package digitallibraryproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DigitalLibraryProducer implements BundleActivator, DigitalLibraryService {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        registration = context.registerService(DigitalLibraryService.class, this, null);
        System.out.println("Digital Library Producer Started");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
        System.out.println("Digital Library Producer Stopped");
    }

    @Override
    public String downloadEBook(String bookTitle) {
        return "Downloading: " + bookTitle;
    }
}
