/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_REFR_DETAILSDetailComponent } from '../../../../../../main/webapp/app/entities/rns-refr-details/rns-refr-details-detail.component';
import { RNS_REFR_DETAILSService } from '../../../../../../main/webapp/app/entities/rns-refr-details/rns-refr-details.service';
import { RNS_REFR_DETAILS } from '../../../../../../main/webapp/app/entities/rns-refr-details/rns-refr-details.model';

describe('Component Tests', () => {

    describe('RNS_REFR_DETAILS Management Detail Component', () => {
        let comp: RNS_REFR_DETAILSDetailComponent;
        let fixture: ComponentFixture<RNS_REFR_DETAILSDetailComponent>;
        let service: RNS_REFR_DETAILSService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_REFR_DETAILSDetailComponent],
                providers: [
                    RNS_REFR_DETAILSService
                ]
            })
            .overrideTemplate(RNS_REFR_DETAILSDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_REFR_DETAILSDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_REFR_DETAILSService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_REFR_DETAILS(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_REFR_DETAILS).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
