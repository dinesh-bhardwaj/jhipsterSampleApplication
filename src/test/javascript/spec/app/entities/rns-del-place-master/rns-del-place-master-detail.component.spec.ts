/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_DEL_PLACE_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-del-place-master/rns-del-place-master-detail.component';
import { RNS_DEL_PLACE_MASTERService } from '../../../../../../main/webapp/app/entities/rns-del-place-master/rns-del-place-master.service';
import { RNS_DEL_PLACE_MASTER } from '../../../../../../main/webapp/app/entities/rns-del-place-master/rns-del-place-master.model';

describe('Component Tests', () => {

    describe('RNS_DEL_PLACE_MASTER Management Detail Component', () => {
        let comp: RNS_DEL_PLACE_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_DEL_PLACE_MASTERDetailComponent>;
        let service: RNS_DEL_PLACE_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_DEL_PLACE_MASTERDetailComponent],
                providers: [
                    RNS_DEL_PLACE_MASTERService
                ]
            })
            .overrideTemplate(RNS_DEL_PLACE_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_DEL_PLACE_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_DEL_PLACE_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_DEL_PLACE_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_DEL_PLACE_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
