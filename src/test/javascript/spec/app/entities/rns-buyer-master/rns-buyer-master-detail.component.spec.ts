/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_BUYER_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-buyer-master/rns-buyer-master-detail.component';
import { RNS_BUYER_MASTERService } from '../../../../../../main/webapp/app/entities/rns-buyer-master/rns-buyer-master.service';
import { RNS_BUYER_MASTER } from '../../../../../../main/webapp/app/entities/rns-buyer-master/rns-buyer-master.model';

describe('Component Tests', () => {

    describe('RNS_BUYER_MASTER Management Detail Component', () => {
        let comp: RNS_BUYER_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_BUYER_MASTERDetailComponent>;
        let service: RNS_BUYER_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_BUYER_MASTERDetailComponent],
                providers: [
                    RNS_BUYER_MASTERService
                ]
            })
            .overrideTemplate(RNS_BUYER_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_BUYER_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_BUYER_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_BUYER_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_BUYER_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
