package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /* Adds parts and products to repository only if database is currently empty */
        if(partRepository.count() == 0 && productRepository.count() == 0 && outsourcedPartRepository.count() == 0) {
            /* Adds outsourced PC parts to the outsourced part repository */
            OutsourcedPart gpu = new OutsourcedPart();
            gpu.setCompanyName("Nvidia");
            gpu.setName("GeforceRTX 5080");
            gpu.setInv(8);
            gpu.setPrice(1359.99);
            gpu.setId(1);
            gpu.setMinInventory(3);
            gpu.setMaxInventory(20);
            outsourcedPartRepository.save(gpu);

            OutsourcedPart cpu = new OutsourcedPart();
            cpu.setCompanyName("Intel Corporation");
            cpu.setName("Intel - Core i9 14th Gen");
            cpu.setInv(10);
            cpu.setPrice(499.99);
            cpu.setId(2);
            cpu.setMinInventory(5);
            cpu.setMaxInventory(25);
            outsourcedPartRepository.save(cpu);
            /* Adds inhouse PC parts to inhouse part repository */
            InhousePart motherboard = new InhousePart();
            motherboard.setName("B650 ATX Motherboard");
            motherboard.setInv(16);
            motherboard.setPrice(199.99);
            motherboard.setId(3);
            motherboard.setMinInventory(3);
            motherboard.setMaxInventory(20);
            partRepository.save(motherboard);

            InhousePart PCCase = new InhousePart();
            PCCase.setName("ATX Mid-Tower PC Case");
            PCCase.setInv(15);
            PCCase.setPrice(89.99);
            PCCase.setId(4);
            PCCase.setMinInventory(1);
            PCCase.setMaxInventory(20);
            partRepository.save(PCCase);

            InhousePart caseFan = new InhousePart();
            caseFan.setName("120mm Magnetic Dome Fan");
            caseFan.setInv(15);
            caseFan.setPrice(139.99);
            caseFan.setId(5);
            caseFan.setMinInventory(1);
            caseFan.setMaxInventory(15);
            partRepository.save(caseFan);
            /* Adds prebuilt PCs to product repository */
            Product prebuilt5060 = new Product();
            prebuilt5060.setName("Prebuilt PC with 5060 GPU");
            prebuilt5060.setPrice(999.99);
            prebuilt5060.setInv(10);
            productRepository.save(prebuilt5060);

            Product prebuilt5070 = new Product();
            prebuilt5070.setName("Prebuilt PC with 5070 GPU");
            prebuilt5070.setPrice(1199.99);
            prebuilt5070.setInv(25);
            productRepository.save(prebuilt5070);

            Product prebuilt5070Ti = new Product();
            prebuilt5070Ti.setName("Prebuilt PC with 5070Ti GPU");
            prebuilt5070Ti.setPrice(1399.99);
            prebuilt5070Ti.setInv(20);
            productRepository.save(prebuilt5070Ti);

            Product prebuilt5080 = new Product();
            prebuilt5080.setName("Prebuilt PC with 5080 GPU");
            prebuilt5080.setPrice(1899.99);
            prebuilt5080.setInv(15);
            productRepository.save(prebuilt5080);

            Product prebuilt5090 = new Product();
            prebuilt5090.setName("Prebuilt PC with 5090 GPU");
            prebuilt5090.setPrice(3599.99);
            prebuilt5090.setInv(10);
            productRepository.save(prebuilt5090);
        }
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
