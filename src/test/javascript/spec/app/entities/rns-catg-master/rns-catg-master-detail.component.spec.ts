/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_CATG_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-catg-master/rns-catg-master-detail.component';
import { RNS_CATG_MASTERService } from '../../../../../../main/webapp/app/entities/rns-catg-master/rns-catg-master.service';
import { RNS_CATG_MASTER } from '../../../../../../main/webapp/app/entities/rns-catg-master/rns-catg-master.model';

describe('Component Tests', () => {

    describe('RNS_CATG_MASTER Management Detail Component', () => {
        let comp: RNS_CATG_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_CATG_MASTERDetailComponent>;
        let service: RNS_CATG_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_CATG_MASTERDetailComponent],
                providers: [
                    RNS_CATG_MASTERService
                ]
            })
            .overrideTemplate(RNS_CATG_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_CATG_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_CATG_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_CATG_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_CATG_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
