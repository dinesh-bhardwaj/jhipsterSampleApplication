/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_REFR_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-refr-master/rns-refr-master-detail.component';
import { RNS_REFR_MASTERService } from '../../../../../../main/webapp/app/entities/rns-refr-master/rns-refr-master.service';
import { RNS_REFR_MASTER } from '../../../../../../main/webapp/app/entities/rns-refr-master/rns-refr-master.model';

describe('Component Tests', () => {

    describe('RNS_REFR_MASTER Management Detail Component', () => {
        let comp: RNS_REFR_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_REFR_MASTERDetailComponent>;
        let service: RNS_REFR_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_REFR_MASTERDetailComponent],
                providers: [
                    RNS_REFR_MASTERService
                ]
            })
            .overrideTemplate(RNS_REFR_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_REFR_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_REFR_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_REFR_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_REFR_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
