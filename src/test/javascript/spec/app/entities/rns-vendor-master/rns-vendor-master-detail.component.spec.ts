/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_VENDOR_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-vendor-master/rns-vendor-master-detail.component';
import { RNS_VENDOR_MASTERService } from '../../../../../../main/webapp/app/entities/rns-vendor-master/rns-vendor-master.service';
import { RNS_VENDOR_MASTER } from '../../../../../../main/webapp/app/entities/rns-vendor-master/rns-vendor-master.model';

describe('Component Tests', () => {

    describe('RNS_VENDOR_MASTER Management Detail Component', () => {
        let comp: RNS_VENDOR_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_VENDOR_MASTERDetailComponent>;
        let service: RNS_VENDOR_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_VENDOR_MASTERDetailComponent],
                providers: [
                    RNS_VENDOR_MASTERService
                ]
            })
            .overrideTemplate(RNS_VENDOR_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_VENDOR_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_VENDOR_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_VENDOR_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_VENDOR_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
