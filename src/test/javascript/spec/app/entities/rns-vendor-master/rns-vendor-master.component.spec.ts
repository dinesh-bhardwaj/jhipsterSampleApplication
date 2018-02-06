/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_VENDOR_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-vendor-master/rns-vendor-master.component';
import { RNS_VENDOR_MASTERService } from '../../../../../../main/webapp/app/entities/rns-vendor-master/rns-vendor-master.service';
import { RNS_VENDOR_MASTER } from '../../../../../../main/webapp/app/entities/rns-vendor-master/rns-vendor-master.model';

describe('Component Tests', () => {

    describe('RNS_VENDOR_MASTER Management Component', () => {
        let comp: RNS_VENDOR_MASTERComponent;
        let fixture: ComponentFixture<RNS_VENDOR_MASTERComponent>;
        let service: RNS_VENDOR_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_VENDOR_MASTERComponent],
                providers: [
                    RNS_VENDOR_MASTERService
                ]
            })
            .overrideTemplate(RNS_VENDOR_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_VENDOR_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_VENDOR_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_VENDOR_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_VENDOR_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
