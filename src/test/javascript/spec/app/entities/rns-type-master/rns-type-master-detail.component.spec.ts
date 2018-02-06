/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_TYPE_MASTERDetailComponent } from '../../../../../../main/webapp/app/entities/rns-type-master/rns-type-master-detail.component';
import { RNS_TYPE_MASTERService } from '../../../../../../main/webapp/app/entities/rns-type-master/rns-type-master.service';
import { RNS_TYPE_MASTER } from '../../../../../../main/webapp/app/entities/rns-type-master/rns-type-master.model';

describe('Component Tests', () => {

    describe('RNS_TYPE_MASTER Management Detail Component', () => {
        let comp: RNS_TYPE_MASTERDetailComponent;
        let fixture: ComponentFixture<RNS_TYPE_MASTERDetailComponent>;
        let service: RNS_TYPE_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_TYPE_MASTERDetailComponent],
                providers: [
                    RNS_TYPE_MASTERService
                ]
            })
            .overrideTemplate(RNS_TYPE_MASTERDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_TYPE_MASTERDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_TYPE_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new RNS_TYPE_MASTER(123)
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith(123);
                expect(comp.rNS_TYPE_MASTER).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
